package day0418.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import day0418.vo.Customer;
import db.utils.ConnectionUtils;

public class CustomerDao {

	// 아이디로 고객정보 조회기능
	public Customer getCustomerById(String id) throws Exception {
		Customer customer = null;
		
		String sql = "select * "
				+ "from tb_customer "
				+ "where customer_id = ? "
				+ "and customer_used_yn = 'Y' ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			customer = new Customer();
			customer.setNo(rs.getInt("customer_no"));
			customer.setName(rs.getString("customer_name"));
			customer.setId(rs.getString("customer_id"));
			customer.setPassword(rs.getString("customer_password"));
			customer.setGender(rs.getString("customer_gender"));
			customer.setEmail(rs.getString("customer_email"));
			customer.setPhone(rs.getString("customer_phone"));
			customer.setPoint(rs.getInt("customer_point"));
			customer.setUsed(rs.getString("customer_used_yn"));
			customer.setCreateDate(rs.getDate("customer_create_date"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return customer;
	}
	
	// 고객정보 저장기능
	public void insertCustomer(Customer customer) throws Exception {
		String sql = "insert into tb_customer "
				+ "values (customer_seq.nextval, ?, ?, ?, ?, ?, ?, 0, 'Y', sysdate) ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, customer.getName());
		pstmt.setString(2, customer.getId());
		pstmt.setString(3, customer.getPassword());
		pstmt.setString(4, customer.getGender());
		pstmt.setString(5, customer.getEmail());
		pstmt.setString(6, customer.getPhone());
	
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	// 고객정보 변경기능
	public void updateCustomer(Customer customer) throws Exception {
		String sql = "update tb_customer "
				+ "set "
				+ "customer_name = ?, "
				+ "customer_password = ?, "
				+ "customer_gender =  ?, "
				+ "customer_email = ?, "
				+ "customer_phone = ?, "
				+ "customer_point = ?, "
				+ "customer_used_yn = ? "
				+ "where customer_no = ? ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, customer.getName());
		pstmt.setString(2, customer.getPassword());
		pstmt.setString(3, customer.getGender());
		pstmt.setString(4, customer.getEmail());
		pstmt.setString(5, customer.getPhone());
		pstmt.setInt(6, customer.getPoint());
		pstmt.setString(7, customer.getUsed());
		pstmt.setInt(8, customer.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public Customer getCustomerByNo(int no) throws Exception {
		Customer customer = null;
		
		String sql = "select * "
				+ "from tb_customer "
				+ "where customer_no = ? "
				+ "and customer_used_yn = 'Y' ";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			customer = new Customer();
			customer.setNo(rs.getInt("customer_no"));
			customer.setName(rs.getString("customer_name"));
			customer.setId(rs.getString("customer_id"));
			customer.setPassword(rs.getString("customer_password"));
			customer.setGender(rs.getString("customer_gender"));
			customer.setEmail(rs.getString("customer_email"));
			customer.setPhone(rs.getString("customer_phone"));
			customer.setPoint(rs.getInt("customer_point"));
			customer.setUsed(rs.getString("customer_used_yn"));
			customer.setCreateDate(rs.getDate("customer_create_date"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return customer;
	}

}
