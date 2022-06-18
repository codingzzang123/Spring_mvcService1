package kr.cat.user.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.cat.user.auth.UserChangePwdCommand;

public class UserChangePwdValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return UserChangePwdCommand.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPassword", "required");
	}
}
