package com.kh.test.customer.model.dto;

import lombok.Getter;
import lombok.Setter;

// DTO 생성
@Getter
@Setter
// DB에서 불러온 데이터를 카멜표기법으로 전환
public class Customer {
	private int customerNo;
	private String customerName;
	private String customerTel;
	private String customerAddress;
	
}
