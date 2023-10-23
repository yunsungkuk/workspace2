package com.kh.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	/** 게시글 작성란 페이지 접속
	 * @return
	 */
	@GetMapping("insert")
	public String insert() {
		return "board/insert";
	}
	
	/** 게시글 상세조회
	 * @param no : 게시글 번호
	 * @param model : 데이터 전달 객체
	 * @param ra : 리다이렉트 시 데이터 전달
	 * @return board/selectOne
	 */
	@GetMapping("selectOne")
	public String selectOne(int no, Model model, 
			RedirectAttributes ra) {
		
		// service로 전달 후 데이터 반환
		Board board = service.selectOne(no);
		
		if(board != null) {
			// 반환 받은 데이터를 세션에 추가
			model.addAttribute("board", board);
			// selectOne 화면에 리턴
			return "board/selectOne";
		}
		// null을 반환 받았을 때 메인페이지로 이동
		ra.addFlashAttribute("message", "존재하지 않는 게시글 입니다.");
		return "redirect:/";
	}
	
	
	
	/** 게시글 작성
	 * @param board 객체 담아두는 공간
	 * @param model 
	 * @param ra 리다이렉트 시 데이터 전달
	 * @return
	 */
	@PostMapping("insert")
	public String insert(Board board, Model model,
			RedirectAttributes ra) {
		
		// service로 전달 후 데이터 반환
		int result = service.insert(board);
		
		// 메시지 출력
		ra.addFlashAttribute("message", "작성 완료");
		
		// 메인 페이지로 전달
		return "redirect:/";
	}
	
	
	/** 비밀번호 일치 시 삭제
	 * @param boardPw 비밀번호 조회
	 * @param boardNo 회원 번호 조회
	 * @param ra 리다이렉트 시 데이터 전달
	 * @return
	 */
	@PostMapping("deleteBoard")
	public String deleteBoard(String boardPw, int boardNo, 
			RedirectAttributes ra) {
		
		// service로 전달 후 데이터 반환
		int result = service.deleteBoard(boardPw, boardNo);
		
		if(result > 0) {
			// 비밀번호 일치 했을 경우 데이터 삭제 후 메인페이지로 이동
			ra.addFlashAttribute("message", "삭제 되었습니다");
			return "redirect:/";
		}
		
		// 비밀번호가 일치하지 않았을 경우 페이지 고정
		ra.addFlashAttribute("message", "비밀번호가 일치하지 않습니다.");
		return "redirect:selectOne?no=" + boardNo;
	}
	
	
	/** 비밀번호 확인 후 게시글 수정란으로 이동
	 * @param boardPw : 비밀번호 조회
	 * @param boardNo : No으로 조회
	 * @param model
	 * @param ra
	 * @return
	 */
	@PostMapping("moveUpdate")
	public String moveUpdate (String boardPw, int boardNo, Model model,
			RedirectAttributes ra) {
		
		// service로 전달 후 데이터 반환
		Board board = service.moveUpdate(boardPw, boardNo);
		
		if(board != null) {
			// 반환 받은 데이터를 세션에 추가
			model.addAttribute("board", board);
			return "board/update";
		}
		 
		ra.addFlashAttribute("message", "비밀번호가 일치하지 않습니다.");
		return "redirect:selectOne?no=" + boardNo;
	}
	
	
	/** 게시글 수정
	 * @param board
	 * @param ra
	 * @return
	 */
	@PostMapping("updateBoard")
	public String updateBoard(Board board, RedirectAttributes ra) {
		
		int result = service.updateBoard(board);
		
		String message = null;
		if(result > 0) {
			message = "수정 성공";
		}
		else	{
			message = "수정 실패";
		}
		
		ra.addFlashAttribute("message", message);
		
		return "redirect:selectOne?no=" + board.getBoardNo();
	}
	
}
