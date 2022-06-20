package kr.cat.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.cat.exception.IdPasswordNotMatchingException;
import kr.cat.exception.MemberNotFoundException;
import kr.cat.user.auth.UserAuthInfo;
import kr.cat.user.auth.UserAuthService;
import kr.cat.user.auth.UserLoginCommand;

@Controller
public class UserLoginController {
	
	@Autowired
	private UserAuthService authService;
	
	@RequestMapping(value="/user/detail")
	public String test(HttpServletRequest request,Model model) {
		String num = request.getParameter("num");
		model.addAttribute("number",num);
		return "user/test";
	}
	
	@RequestMapping(value="/user/login",method=RequestMethod.GET)
	public String loginForm(UserLoginCommand userLoginCommand) {
		return "user/loginForm";
	}
	
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	public String loginResult(UserLoginCommand userLoginCommand,Errors errors,HttpSession session) {
		new UserLoginValidator().validate(userLoginCommand, errors);
		
		if(errors.hasErrors()) {
			System.out.println("error detected");
			return "user/loginForm";
		}
		try {
			UserAuthInfo authInfo = authService.authenticate(userLoginCommand.getId(), userLoginCommand.getPw());
			session.setAttribute("authInfo", authInfo);
			return "redirect:/main";
		}catch(MemberNotFoundException e) {
			System.out.println(e.getMessage());
			errors.reject("MemberNotMatching");
			return "user/loginForm";
		}catch(IdPasswordNotMatchingException e) {
			System.out.println(e.getMessage());
			errors.reject("IdPasswordMatching");
			return "user/loginForm";
		}
	}
	
	
}
