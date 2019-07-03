package db.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDemo {

	public static void main(String[] args) throws Exception {
		String sql = "select * from user_contacts";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			int no = rs.getInt("user_no");
			String name = rs.getString("user_name");
			String phone = rs.getString("user_phone");
			
			System.out.println(no + ", " + name + ", " + phone);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}
}
