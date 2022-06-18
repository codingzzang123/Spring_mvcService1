package kr.cat.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.cat.exception.AlreadyExistingMemberException;
import kr.cat.service.MemberService;
import kr.cat.user.MemberCommand;
import kr.cat.user.MemberVO;

import java.util.*;

@Controller
public class UserJoinController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/user/join") /* 로그인 폼 출력 */
	public String login(Model model) {
		model.addAttribute("formData", new MemberCommand());
		return "user/join";
	}
	
	@RequestMapping(value="/user/result",method=RequestMethod.POST)
	public String loginSucess(@ModelAttribute("formData")MemberCommand req,Errors errors) {
		new UserRegisterValidator().validate(req, errors);
		if(errors.hasErrors()) {
			System.out.println("검증에러 있음");
			return "user/join";
		}
		try {
			service.regist(req);
			return "user/result";
		}catch(AlreadyExistingMemberException e) { //catch(new AlreadyExistingMemberException("이미 존재하는 아이디 입니다.") e)
			System.out.println(e.getMessage());
			errors.rejectValue("id", "duplicate");
			return "user/join";
		}
	}
	
	@RequestMapping(value="/user/view",method=RequestMethod.GET) /*멤버 리스트 출력*/
	public String memberList(Model model, MemberVO member) {
		List<MemberVO> ls = new ArrayList<>();
		ls = service.memberSelectAll(member);
		model.addAttribute("ls",ls);
		
		return "user/memberView";
	}
}
