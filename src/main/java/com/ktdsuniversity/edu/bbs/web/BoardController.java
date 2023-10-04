package com.ktdsuniversity.edu.bbs.web;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniversity.edu.bbs.service.BoardService;
import com.ktdsuniversity.edu.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.beans.FileHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class BoardController {
	
	@Autowired
	private FileHandler fileHandler;
	
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/list")
	public ModelAndView viewBoardList() {
		
		BoardListVO boardListVO = boardService.getAllBoard();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/boardlist");
		modelAndView.addObject("boardList", boardListVO);
		return modelAndView;
		
	}
	
	@GetMapping("/board/write")
	public String viewBoardWritePage() {
		return "board/boardwrite";
	}
	
	@PostMapping("/board/write")
	public ModelAndView boardWrite(@Valid @ModelAttribute BoardVO boardVO
								   , BindingResult bindingResult //validation 실패 결과를 갖고있다. valid 바로 다음에 나와야 함(서순 중요!)
								   , @RequestParam MultipartFile file
								   , HttpServletRequest request) {
		
		boardVO.setIpAddr(request.getRemoteAddr());
		
		ModelAndView modelAndView = new ModelAndView();
		
		//Validation 체크한 것 중 실패한 것이 있다면
		if (bindingResult.hasErrors()) {
			// 화면을 보여준다 & 게시글 등록은 하지 않는다
			modelAndView.setViewName("board/boardwrite");
			modelAndView.addObject("boardVO", boardVO);
			return modelAndView;
		}
		
		//게시글 등록
		boolean isSuccess = boardService.createNewBoard(boardVO, file);
		if(isSuccess) {
			//게시글 등록 결과가 성공이면 '/board/list'로 이동
			modelAndView.setViewName("redirect:/board/list");
			return modelAndView;
		}
		else {
			//게시글 등록 결과가 실패라면 게시글 등록(작성)화면으로 데이터를 보냄
			//게시글 등록 화면에서 boardVO값으로 등록 값을 설정
			modelAndView.setViewName("board/boardwrite");
			modelAndView.addObject("boardVO", boardVO);
			return modelAndView;
		}
	}
	
	@GetMapping("/board/modify/{id}")
	public ModelAndView boardModify(@PathVariable int id) {
		BoardVO boardVO = boardService.getOneBoard(id, false);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/boardmodify");
		modelAndView.addObject("boardVO", boardVO);
		
		return modelAndView;
	}
	
	@PostMapping("/board/modify")
	public ModelAndView boardUpdate(@ModelAttribute BoardVO boardVO
								  , @RequestParam MultipartFile file) {
		ModelAndView modelAndView = new ModelAndView();
		boolean isSuccess = boardService.updateOneBoard(boardVO, file);
		
		if (isSuccess) {
			modelAndView.setViewName("redirect:/board/view?id=" + boardVO.getId());
			return modelAndView;
		}
		else {
			modelAndView.setViewName("board/boardmodify");
			modelAndView.addObject("boardVO", boardVO);
			return modelAndView;
		}
	}
	
	@GetMapping("/board/view")
	public ModelAndView viewOneBoard(@RequestParam int id) {
		BoardVO boardVO = boardService.getOneBoard(id, true);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/boardview");
		modelAndView.addObject("boardVO", boardVO);
		
		return modelAndView;
	}
	
	@GetMapping("/board/file/download/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable int id) {
		BoardVO boardVO = boardService.getOneBoard(id, false);
		if (boardVO == null) {
			throw new IllegalArgumentException("잘못된 접근입니다.");
		}
		
		File storedFile = fileHandler.getStoredFile(boardVO.getFileName());
		return fileHandler.getResponseEntity(storedFile, boardVO.getOriginFileName());
		
	}
	
	
	@GetMapping("/board/delete/{id}")
	public String deleteBoard(@PathVariable int id) {
		boolean isSuccess = boardService.deleteOneBoard(id);
		if (isSuccess) {
			return "redirect:/board/list";
		}
		else {
			return "redirect:/board/view/?id=" + id;
		}
	}
	
}
