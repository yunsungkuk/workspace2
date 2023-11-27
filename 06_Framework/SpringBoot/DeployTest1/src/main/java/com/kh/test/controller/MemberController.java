package com.kh.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@PostMapping("loginTest")
	public String loginTest(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			Model model
			) {
		String message = null;
		if(id.equals("user01") && pw.equals("pass01")) {
			message = "성공";
		} else {
			message = "실패";
		}
		model.addAttribute("message", message);
		return "loginResult";
	}
}