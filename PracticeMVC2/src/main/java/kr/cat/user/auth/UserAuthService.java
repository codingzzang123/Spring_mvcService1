package kr.cat.user.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.cat.exception.*;
import kr.cat.user.MemberDao;
import kr.cat.user.MemberVO;

@Service
public class UserAuthService {
	@Autowired
	private MemberDao dao;
	
	public UserAuthInfo authenticate(String id,String pw) {
		MemberVO member = dao.selectById(id);
		if(member == null) {
			throw new MemberNotFoundException("존재하지 않는 아이디"); 
		}
		if(!member.matchPassword(pw)) {
			throw new IdPasswordNotMatchingException("비밀번호가 일치 하지않음");
		}
		return new UserAuthInfo(member.getMemberId(),member.getMemberName());
	}
	
}
