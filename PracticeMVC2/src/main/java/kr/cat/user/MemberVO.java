package kr.cat.user;

import kr.cat.exception.IdPasswordNotMatchingException;

public class MemberVO {
		private String memberId;
		private String memberPw;
		private String memberName;
		
		public String getMemberId() {
			return memberId;
		}
		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}
		public String getMemberPw() {
			return memberPw;
		}
		public void setMemberPw(String memberPw) {
			this.memberPw = memberPw;
		}
		public String getMemberName() {
			return memberName;
		}
		public void setMemberName(String memberName) {
			this.memberName = memberName;
		}
		public MemberVO(String memberId, String memberPw, String memberName) {
			super();
			this.memberId = memberId;
			this.memberPw = memberPw;
			this.memberName = memberName;
		}
		public MemberVO() {
			super();
		}
		public boolean matchPassword(String pw) {
			return this.memberPw.equals(pw);
		}
		public void changePassword(String oldPassword, String newPassword){
			if(!memberPw.equals(oldPassword)) {
				throw new IdPasswordNotMatchingException("일치하지않는 패스워드");	//사용자 정의 예외를 던진다.
			}
			this.memberPw = newPassword;
		}
}

