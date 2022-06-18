package kr.cat.service;

import kr.cat.exception.AlreadyExistingMemberException;
import kr.cat.user.MemberCommand;
import kr.cat.user.MemberVO;
import java.util.*;
public interface MemberService {
	public MemberVO memberSelectOne(MemberVO member);
	
	public List<MemberVO> memberSelectAll(MemberVO member);
	
	public void regist(MemberCommand req)throws AlreadyExistingMemberException;
}
