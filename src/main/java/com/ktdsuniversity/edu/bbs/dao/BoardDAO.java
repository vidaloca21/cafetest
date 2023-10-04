package com.ktdsuniversity.edu.bbs.dao;

import java.util.List;

import com.ktdsuniversity.edu.bbs.vo.BoardVO;

public interface BoardDAO {
	
	/**
	 * DB에 저장된 모든 게시글의 수를 조회
	 * @return 게시글의 수(int)
	 */
	public int getBoardAllCount();
	
	/**
	 * DB에 저장된 모든 게시글의 목록을 조회
	 * @return 게시글 목록(List)
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * DB에 새로운 게시글을 등록한다
	 * @param boardVO 사용자가 입력한 게시글 정보
	 * @return DB에 Insert한 개수
	 */
	public int createNewBoard(BoardVO boardVO);
	
	/**
	 * 파라미터로 전달받은 게시글ID의 게시글 정보를 조회한다.
	 * @param id 게시글ID(번호)
	 * @return
	 */
	public int increaseViewCount(int id);
	
	/**
	 * 파라미터로 전달받은 게시글ID의 게시글 정보를 조회한다.
	 * @param id 게시글ID(번호)
	 * @return
	 */
	public BoardVO getOneBoard(int id);
	
	/**
	 * DB에 게시글 정보를 수정한다.
	 * BoardVO의 id값에 수정할 게시글의 id 값이 있어야 한다.
	 * @param boardVO 사용자가 수정한 게시글의 정보
	 * @return DB에 update한 게시글의 수
	 */
	public int updateOneBoard(BoardVO boardVO);
	
	/**
	 * 파라미터로 전달받은 게시글ID의 게시글을 삭제한다.
	 * @param id 게시글ID(번호)
	 * @return DB에 DELETE한 게시글의 수
	 */
	public int deleteOneBoard(int id);
	
}
