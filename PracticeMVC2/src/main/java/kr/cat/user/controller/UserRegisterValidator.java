package kr.cat.user.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import kr.cat.user.MemberCommand;


public class UserRegisterValidator implements Validator{
	private static final String idRegExp = "^[a-z0-9]{4,10}$";
	private Pattern pattern;
	
	public UserRegisterValidator() {
		pattern = Pattern.compile(idRegExp);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		// 스프링 mvc에서 전달받은 객체를 자동으로 검증할 경우 올바르게 구현해야 함
		return MemberCommand.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		MemberCommand regReq = (MemberCommand)target;
		if(regReq.getId() == null || regReq.getId().trim().isEmpty()) {
			errors.reject("id", "required");
		}else {
			Matcher matcher = pattern.matcher(regReq.getId());
			if(!matcher.matches()) {
				errors.rejectValue("id", "bad");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "id", "required");
		ValidationUtils.rejectIfEmpty(errors, "pw", "required");
	}
}
