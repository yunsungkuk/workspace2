package edu.kh.project.email.model.service;

import java.util.Map;

public interface EmailService {

	/** 이메일 발송
	 * @param htmlName
	 * @param email
	 * @return result
	 */
	int sendEmail(String htmlName, String email);

	/** 
	 * @param paramMap
	 * @return
	 */
	int checkAuthKey(Map<String, Object> paramMap);

}
