package kr.cat.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.cat.exception.IdPasswordNotMatchingException;
import kr.cat.user.auth.UserAuthInfo;
import kr.cat.user.auth.UserChangePwdCommand;
import kr.cat.user.auth.UserChangePwdService;


@Controller
@RequestMapping("user/changePassword")
public class UserChangePwdController {
	@Autowired
	private UserChangePwdService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(@ModelAttribute("command")UserChangePwdCommand command) {
		return "user/changePwdForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")UserChangePwdCommand command
			,Errors errors,HttpSession session) {
		new UserChangePwdValidator().validate(command, errors);
		
		if(errors.hasErrors()) {
			return "user/changePwdForm";
		}
		UserAuthInfo authInfo = (UserAuthInfo)session.getAttribute("authInfo");
		try {
			service.changePassword(authInfo.getId(), command.getCurrentPassword(), command.getNewPassword());
			return "user/changePwdResult";
		}catch(IdPasswordNotMatchingException e) {
			System.out.println(e.getMessage());
			errors.rejectValue("currentPassword","IdPasswordNotMatching");
			return "user/changePwdForm";
		}
	}
}
