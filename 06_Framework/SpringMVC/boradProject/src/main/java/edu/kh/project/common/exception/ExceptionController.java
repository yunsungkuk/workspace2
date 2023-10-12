package edu.kh.project.common.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	
	@ExceptionHandler(Exception.class) 
	public String exceptionHandler(Exception e, Model model) {
		
		e.printStackTrace(); // 콘솔에 에러 발생 메서드 모두 출력
	  
		// model : 값 전달 객체 (기본 request scope) 
		model.addAttribute("e", e);
		
		// /WEB-INF/views/common/error.jsp로 forward 
	    return "common/error";
	  
	}
	 

}
