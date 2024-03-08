package com.example.demo.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.domain.NoticeVO;

/**
 * MecNoticeValidator.java 
 * ==============================================
 *
 * @author MAYEYE_JAR
 * @history 작성일 작성자 변경내용
 * @history 2019-04-08 MAYEYE_JAR 최초 작성
 * ==============================================
 */
@Component
public class MecNoticeValidator implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return NoticeVO.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		NoticeVO NoticeVO = (NoticeVO)o;
		if (NoticeVO.getNoContent().length() < 10) {
			errors.rejectValue("noContent", "required", "10 byte 이상 입력해주세요.");
		}
	}
}
