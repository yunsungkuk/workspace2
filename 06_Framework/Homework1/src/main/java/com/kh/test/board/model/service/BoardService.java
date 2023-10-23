package com.kh.test.board.model.service;

import java.util.List;

import com.kh.test.board.model.dto.Board;

public interface BoardService {

	
	/** 게시글 목록 조회
	 * @return boardList
	 */
	List<Board> selectBoardList();

	/** 게시글 작성
	 * @param board
	 * @return result
	 */
	int insert(Board board);

	/** 게시글 상세 조회
	 * @param no
	 * @return
	 */
	Board selectOne(int no);

	/** 비밀번호 조회 후 삭제
	 * @param boardPw
	 * @param boardNo
	 * @return
	 */
	int deleteBoard(String boardPw, int boardNo);

	/** 비밀번호 조회 후 수정 게시판으로 접속
	 * @param boardPw
	 * @param boardNo
	 * @return
	 */
	Board moveUpdate(String boardPw, int boardNo);

	/** 게시글 수정
	 * @param board
	 * @return
	 */
	int updateBoard(Board board);





}
