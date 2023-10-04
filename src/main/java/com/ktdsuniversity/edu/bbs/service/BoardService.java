package com.ktdsuniversity.edu.bbs.service;

import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.bbs.vo.BoardVO;

public interface BoardService {
	
	public BoardListVO getAllBoard();
	
	/**
	 * 새로운 게시글을 DB에 등록한다
	 * @param boardVO 사용자가 입력한 게시글 정보
	 * @param file 사용자가 업로드한 파일의 정보
	 * @return 정상 등록 여부
	 */
	public boolean createNewBoard(BoardVO boardVO, MultipartFile file);
	
	/**
	 * 파라미터로 전달받은 id로 게시글을 조회한다.
	 * 게시글 조회 시 조회수도 1 증가한다.
	 * @param id 조회할 id
	 * @param isIncrease 값이 true면 조회수를 증가시킨다
	 * @return 게시글 정보
	 */
	public BoardVO getOneBoard(int id, boolean isIncrease);
	
	/**
	 * BoardVO의 ID값에 수정할 게시글의
	 * @param boardVO
	 * @param file
	 * @return
	 */
	public boolean updateOneBoard(BoardVO boardVO, MultipartFile file);
	
	/**
	 * 파라미터로 전달받은 게시글ID의 게시글을 삭제한다.
	 * @param id 게시글ID(번호)
	 * @return 정상적으로 삭제되었는지 여부
	 */
	public boolean deleteOneBoard(int id);
	
}
