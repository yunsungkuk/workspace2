package com.kh.test.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

import oracle.jdbc.driver.Message;

@Controller
@RequestMapping
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("selectBulletin")
	public String selectBulletin ( String boardTitle , Model model ) {
		
		List<Board> selectBoard = service.selectBulletin(boardTitle);
		
		if(selectBoard.size() != 0) {
			model.addAttribute( "selectBoard", selectBoard );
			return "searchSuccess";
		}
		return "searchFail";
	}
	
}
