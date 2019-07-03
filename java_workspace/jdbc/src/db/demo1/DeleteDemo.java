package db.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDemo {

	public static void main(String[] args) throws Exception {
		String sql = "delete from user_contacts where user_name = ?";
		
		Class.forName("oracle.jdbc.OracleDriver");	
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, "홍길동");
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "개의 행이 삭제되었습니다");
		
		pstmt.close();
		connection.close();
		
	}
}
