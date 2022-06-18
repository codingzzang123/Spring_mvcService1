package kr.cat.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper<MemberVO>{

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO member = new MemberVO(
				rs.getString(1),
				rs.getString(2),
				rs.getString(3));
		return member;
	}

}
