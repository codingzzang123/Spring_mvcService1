package kr.cat.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.cat.exception.AlreadyExistingMemberException;
import kr.cat.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDao dao;
	
	@Override
	public MemberVO memberSelectOne(MemberVO member) {
		return dao.selectById(member.getMemberId());
	}
	@Override
	public List<MemberVO> memberSelectAll(MemberVO member) {
		return dao.selectAll();
	}
	@Override
	public void regist(MemberCommand req)throws AlreadyExistingMemberException{
		MemberVO member = dao.selectById(req.getId());
		
		if(member != null) {
			throw new AlreadyExistingMemberException("이미 존재하는 이메일:" + req.getId());
		}
		dao.regist(req);
	}
}
