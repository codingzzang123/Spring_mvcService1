package kr.cat.user.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.cat.exception.MemberNotFoundException;
import kr.cat.user.MemberDao;
import kr.cat.user.MemberVO;

@Service
public class UserChangePwdService {
	@Autowired
	private MemberDao memberDao;
	
	
	@Transactional
	public void changePassword(String id, String oldPwd, String newPwd) {
		
		MemberVO member = memberDao.selectById(id);
		if(member == null) {
			throw new MemberNotFoundException("존재하지않는 멤버");
		}
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
}
