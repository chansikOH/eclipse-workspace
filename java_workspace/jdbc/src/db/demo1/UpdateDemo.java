package db.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) throws Exception {
		String sql = "update user_contacts "
				+ "set "
				+ "user_name = ?, "
				+ "user_phone = ? "
				+ "where user_no = ? ";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 사용자번호 입력> ");
		int no = sc.nextInt();
		System.out.print("새 이름 입력> ");
		String name = sc.next();
		System.out.print("새 연락처 입력> ");
		String phone = sc.next();
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, phone);
		pstmt.setInt(3, no);
		
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "개의 행이 변경되었습니다.");
		
		pstmt.close();
		conn.close();
		sc.close();
	}
}
