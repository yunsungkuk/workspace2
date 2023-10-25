package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.service.UserService;

@Controller
public class UesrController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("searchMember")
	public String searchMember ( int searchNo, Model model ) {
		
		User searchMember = service.searchMember(searchNo);
		
		if( searchMember != null ) {
			model.addAttribute("searchMember", searchMember );
			return "searchSuccess";
		}
		return "searchFail";
	}
}
