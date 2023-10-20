package com.kh.test.customer.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.mapper.CustomerMapper;

@Service
public class CustomerServiceiml implements CustomerService {
	
	@Autowired
	private CustomerMapper mapper;
	
	@Override
	public int selectMember(Customer customer) {
		
		
		
		return mapper.selectMember(customer);
	}

}
