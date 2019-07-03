package db.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class InsertDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("주소록 등록 프로그램");
		
		System.out.print("순번 입력> ");
		int no = scanner.nextInt();
		System.out.print("이름 입력> ");
		String name = scanner.next();
		System.out.print("연락처 입력> ");
		String phone = scanner.next();
		
		// 1. JDBC 드라이버 메모리 로딩
		Class.forName("oracle.jdbc.OracleDriver");
		
		// 2. Database와 연결을 유지하는 Connection객체 획득하기 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		// 3. 실행할 쿼리 정의
		String sql = "insert into user_contacts(user_no, user_name, user_phone, user_create_date)"
				+ "values(?, ?, ?, sysdate)";		// 값이 들어갈 자리에 ? 를 넣어줌
		
		// 4. 쿼리를 데이터베이스로 전송하는 PreparedStatement객체 획득하기 
		PreparedStatement pstmt = connection.prepareStatement(sql);
		
		// 5. PreparedStatemant의 setXXX(인덱스, 값)메소드를 사용해서 ?와 치환될 값 설정하기
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		
		// 6. 쿼리 실행
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "개의 행이 추가되었습니다.");
		
		// 7. 자원해제
		pstmt.close();
		connection.close();		// 획득한 순서의 역순으로 해제
		scanner.close();
	}
}
