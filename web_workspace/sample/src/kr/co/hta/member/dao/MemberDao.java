package kr.co.hta.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.hta.member.vo.Member;
import kr.co.hta.util.ConnectionUtils;

public class MemberDao {

	public Member getMemberById(String userId) throws Exception {
		Member member = null;
		
		String sql = "select * "
				+ "from hta_members "
				+ "where member_id = ? ";
		
		Connection con = ConnectionUtils.hrConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			member = new Member();
			member.setId(rs.getString("member_id"));
			member.setPwd(rs.getString("member_pwd"));
			member.setName(rs.getString("member_name"));
			member.setEmail(rs.getString("member_email"));
			member.setUsed(rs.getString("member_used_yn"));
			member.setCreateDate(rs.getTimestamp("member_create_date"));
			member.setType(rs.getString("member_type"));		
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return member;
	}
	
	public void insertMember(Member member) throws Exception {
		String sql = "insert into hta_members(member_id, member_pwd, member_name, member_email) "
				+ "values(?, ?, ?, ?) ";
		
		Connection con = ConnectionUtils.hrConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPwd());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getEmail());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public void updateMember(Member member) throws Exception {
		String sql = "update hta_members "
				+ "set "
				+ "		member_pwd = ?, "
				+ "		member_name = ?, "
				+ "		member_email = ? "
				+ "where member_id = ? ";
		
		Connection con = ConnectionUtils.hrConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, member.getPwd());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getEmail());
		pstmt.setString(4, member.getId());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
}
