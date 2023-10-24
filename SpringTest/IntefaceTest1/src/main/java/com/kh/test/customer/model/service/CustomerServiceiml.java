package com.kh.test.customer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.mapper.CustomerMapper;

@Service // 서비스 bean 생성
public class CustomerServiceiml implements CustomerService {
	
	// mapper 의존성 주입
	@Autowired
	private CustomerMapper mapper;
	
	/** 고객 추가
	 *
	 */
	@Override
	public int selectMember(Customer customer) {
		return mapper.selectMember(customer);
	}

}
