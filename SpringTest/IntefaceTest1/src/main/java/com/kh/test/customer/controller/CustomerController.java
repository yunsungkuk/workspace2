package com.kh.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.service.CustomerService;


@Controller // 컨트롤러 어노테이션
public class CustomerController {
	
	// 서비스 의존성 주입
	@Autowired 
	private CustomerService service;
	
	@PostMapping("selectMember") // POST 어노테이션
								// 커맨드 객체 생성    받은 데이터를 모아놓는 객체
	public String selectMember( Customer customer , Model model) {
		
		// 서비스에 호출 후 데이터 반환
		int result = service.selectMember(customer);
		
		// 반환 받은 데이터를 뷰에 전달
//		model.addAttribute("customerName", customer.getCustomerName());
		
		// result에 반환
		return "result";
	}
	
	
}
