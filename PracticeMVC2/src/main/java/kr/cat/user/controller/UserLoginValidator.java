package kr.cat.user.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.cat.user.auth.UserLoginCommand;

public class UserLoginValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return UserLoginCommand.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
		ValidationUtils.rejectIfEmpty(errors, "pw", "required");
	}
}
