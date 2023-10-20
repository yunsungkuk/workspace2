package com.kh.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("selectMember")
	public String selectMember( Customer customer , Model model) {
		
		int result = service.selectMember(customer);
		
		model.addAttribute("customerName", customer.getCustomerName());
		
		return "result";
	}
	
	
}
