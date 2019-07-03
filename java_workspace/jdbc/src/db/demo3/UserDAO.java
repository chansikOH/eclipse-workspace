package db.demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.utils.ConnectionUtils;

public class UserDAO {

	// 사용자정보 변경하기
	 public void updateUser(UserVO user) throws Exception {
		 String sql = "update store_users "
		 		+ "set "
		 		+ "user_name = ?, "
		 		+ "user_pwd = ?, "
		 		+ "user_phone = ?, "
		 		+ "user_email = ?, "
		 		+ "user_point = ? "
		 		+ "where user_id = ? ";
		 
		 Connection con = ConnectionUtils.getConnection();
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, user.getName());
		 pstmt.setString(2, user.getPwd());
		 pstmt.setString(3, user.getPhone());
		 pstmt.setString(4, user.getEmail());
		 pstmt.setInt(5, user.getPoint());
		 pstmt.setString(6, user.getId());
		 pstmt.executeUpdate();
		 
		 pstmt.close();
		 con.close();
		 
	 }
	
	// 새로운 사용자 정보 추가하기
	 public void addUser(UserVO user) throws Exception {
		 String sql = "insert into store_users(user_id, user_name, user_pwd, user_phone, user_email, user_point)"
		 		+ "values(?, ?, ?, ?, ?, 0)";
		 
		 Connection con = ConnectionUtils.getConnection();
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, user.getId());
		 pstmt.setString(2, user.getName());
		 pstmt.setString(3, user.getPwd());
		 pstmt.setString(4, user.getPhone());
		 pstmt.setString(5, user.getEmail());
		 pstmt.executeUpdate();
		 
		 pstmt.close();
		 con.close();
	 }
	
	// 지정된 아이디에 해당하는 사용자 정보 삭제하기
	 public void deleteUser(String id) throws Exception {
		 String sql = "delete from store_users where user_id = ?";
		
		 Connection con = ConnectionUtils.getConnection();
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, id);
		 pstmt.executeUpdate();
		 
		 pstmt.close();
		 con.close();
	 }
	
	// 지정된 이름에 해당하는 사용자 정보 조회하기
	 public ArrayList<UserVO> searchUsersByName(String name) throws Exception {
		 ArrayList<UserVO> users = new ArrayList<UserVO>();
		 
		 String sql = "select * from store_users where user_name = ? ";
		 Connection con = ConnectionUtils.getConnection();
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, name);
		 
		 ResultSet rs = pstmt.executeQuery();
		 
		 while(rs.next()) {
			UserVO user = new UserVO();
			user.setId(rs.getString("user_id"));
			user.setName(rs.getString("user_name"));
			user.setPwd(rs.getString("user_pwd"));
			user.setPhone(rs.getString("user_phone"));
			user.setEmail(rs.getString("user_email"));
			user.setPoint(rs.getInt("user_point"));
			user.setCreateDate(rs.getDate("user_create_date"));
				
			users.add(user);
		 }
		 
		 rs.close();
		 pstmt.close();
		 con.close();
		 
		 return users;
	 }
	
	// 지정된 아이디에 해당하는 사용자 정보 조회하기
	 public UserVO getUserById(String id) throws Exception {
		 UserVO user = null;
		 
		 String sql = "select * from store_users where user_id = ?";
		 
		 Connection con = ConnectionUtils.getConnection();
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, id);
		 ResultSet rs = pstmt.executeQuery();
		 
		 
		 while (rs.next()) {
			 user = new UserVO();
			 
			 user.setId(rs.getString("user_id"));
			 user.setName(rs.getString("user_name"));
			 user.setPwd(rs.getString("user_pwd"));
			 user.setPhone(rs.getString("user_phone"));
			 user.setEmail(rs.getString("user_email"));
			 user.setPoint(rs.getInt("user_point"));
			 user.setCreateDate(rs.getDate("user_create_date"));
		 }
		 
		 rs.close();
		 pstmt.close();
		 con.close();
		 
		 return user;
	 }
	
	// 전체 사용자 정보 조회하기
	public ArrayList<UserVO> getAllUsers() throws Exception {
		ArrayList<UserVO> users = new ArrayList<UserVO>();
		String sql = "select * from store_users order by user_id asc";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
//			String id = rs.getString("user_id");
//			String name = rs.getString("user_name");
//			String pwd = rs.getString("user_pwd");
//			String phone = rs.getString("user_phone");
//			String email = rs.getString("user_email");
//			int point = rs.getInt("user_point");
//			Date createDate = rs.getDate("user_create_date");
					
			UserVO user = new UserVO();
			user.setId(rs.getString("user_id"));
			user.setName(rs.getString("user_name"));
			user.setPwd(rs.getString("user_pwd"));
			user.setPhone(rs.getString("user_phone"));
			user.setEmail(rs.getString("user_email"));
			user.setPoint(rs.getInt("user_point"));
			user.setCreateDate(rs.getDate("user_create_date"));
			
			users.add(user);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return users;
	}
}
