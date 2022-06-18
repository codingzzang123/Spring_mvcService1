package kr.cat.user;


import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component	
public class MemberDao {
	private static final Logger logger = LogManager.getLogger(MemberDao.class);
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public MemberDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		logger.info("MemberDao()출력 {}", 1234);
	}
	
	public MemberVO selectById(String id) { //select
		List<MemberVO> result = jdbcTemplate.query(
				"select * from member where id = ?", 
				new MemberRowMapper(),
				id);
		return result.isEmpty()? null:result.get(0);
	}
	
	public List<MemberVO> selectAll(){
		List<MemberVO> result = jdbcTemplate.query(
				"select * from member",
				new MemberRowMapper());
		return result;
	}
	
	public int count() {
		String query = "select count(*) from member";
		//쿼리 결과가 하나만 있을 경우 활용(쿼리 결과가 하나가 아니면 예외)
		return jdbcTemplate.queryForObject(query, Integer.class);
	}
	
	public void regist(MemberCommand req) { /* 커맨드 객체를 활용하여 데이터 주입 */
		String query = "insert into member values(?,?,?)";
		jdbcTemplate.update(query, req.getId(),req.getPw(),req.getName());
	}
	
	public void update(MemberVO member) {
		String query = "update member set pw=? where id=?";
		jdbcTemplate.update(query,member.getMemberPw() ,member.getMemberId());
	}
//  insert, update, delete를 구현하는 방법 1
//	public void update(Member member) { //update
//		String query = "update \"MEMBER\" set \"NAME\"= ?, \"PASSWORD\" = ? where \"EMAIL\"= ?";
//		jdbcTemplate.update(query, member.getName(), member.getPassword(), member.getEmail());
//	}

//  insert, update, delete를 구현하는 방법 2
//	class MyPreparedStatementCreator implements PreparedStatementCreator{
//
//		private Member member;
//		
//		public MyPreparedStatementCreator(Member member) {
//			this.member = member;
//		}
//		
//		@Override
//		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//			String query = "update \"MEMBER\" set \"NAME\"= ?, \"PASSWORD\" = ? where \"EMAIL\"= ?";
//			PreparedStatement pstmt = con.prepareStatement(query);
//			pstmt.setString(1, member.getName());
//			pstmt.setString(2, member.getPassword());
//			pstmt.setString(3, member.getEmail());
//			return pstmt;
//		}
//		
//	}
//	
//	public void update(Member member) {
//		jdbcTemplate.update(new MyPreparedStatementCreator(member));
//	}
	
	
//  insert, update, delete를 구현하는 방법 3(익명(무명)중첩클래스 활용)
//	public void update(Member member) {
//		jdbcTemplate.update(new PreparedStatementCreator() {
//
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				String query = "update \"MEMBER\" set \"NAME\"= ?, \"PASSWORD\" = ? where \"EMAIL\"= ?";
//				PreparedStatement pstmt = con.prepareStatement(query);
//				pstmt.setString(1, member.getName());
//				pstmt.setString(2, member.getPassword());
//				pstmt.setString(3, member.getEmail());
//				return pstmt;
//			}
//			
//		});
//	}
//	
//	public void update2(Member member) {
//		jdbcTemplate.update(new PreparedStatementCreator() {
//
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement pstmt = con.prepareStatement("UPDATE MEMBER SET NAME=?, PASSWORD=? WHERE EMAIL=?");
//				pstmt.setString(1, member.getName());
//				pstmt.setString(2, member.getPassword());
//				pstmt.setString(3, member.getEmail());
//				return pstmt;
//			}
//
//		});
//	}
//
//	
//	
//	public void insert(Member member){ //insert
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		String query = "insert into \"MEMBER\" (\"ID\", \"EMAIL\", \"PASSWORD\", \"NAME\", \"REGDATE\")"
//				+ " values (\"MEMBER_SEQ\".nextval, ?, ?, ?, sysdate)";
//		jdbcTemplate.update(new PreparedStatementCreator() {
//
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement pstmt = con.prepareStatement(query, new String[] {"ID"});
//				pstmt.setString(1, member.getEmail());
//				pstmt.setString(2, member.getPassword());
//				pstmt.setString(3, member.getName());
//
//				return pstmt;
//			}
//			
//		}, keyHolder); //prepareStatement에 전달한 String배열에 해당하는 컬럼에 사용된 값을 키홀더에 저장
//		Number key = keyHolder.getKey();
//		member.setId(key.longValue());
//	}
	
}


