package db.demo2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookService {
	
	/*
	 *  1. SQL 정의
	 *  2. 드라이브 메모리 로딩
	 *  3. Connection 획득
	 *  4. PreparedStatement 획득
	 *  5. ?에 값 설정
	 *  6. 실행
	 *  7. ResultSet 처리
	 *  8. 자원해제
	 */

	// 모든 책정보를 조회하는 기능
	public void selectAllBooks() throws Exception {
		String sql = "select "
				+ "book_no, "
				+ "book_title, "
				+ "book_author, "
				+ "book_publisher, "
				+ "book_price, "
				+ "book_pubdate, "
				+ "book_create_date "
				+ "from books "
				+ "order by 1";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		printBooks(rs);
		
		rs.close();
		pstmt.close();
		conn.close();		
	}
	
	// 제목을 전달받아서 그 제목에 해당하는 책정보를 조회하는 기능
	public void selectBooksByTitle(String keyword) throws Exception {
		String sql = "select "
				+ "book_no, "
				+ "book_title, "
				+ "book_author, "
				+ "book_publisher, "
				+ "book_price, "
				+ "book_pubdate, "
				+ "book_create_date "
				+ "from books "
				+ "where book_title like '%'||?||'%' "
				+ "order by 1";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, keyword);
		
		ResultSet rs = pstmt.executeQuery();
		
		printBooks(rs);
		
		rs.close();
		pstmt.close();
		conn.close();
	}
	
	// 책정보를 전달받아서 DB에 저장하는 기능
	public void insertNewBook(int no, String title, String author, String publisher, int price, 
			String pubdate) throws Exception{
		String sql = "insert into books(book_no, book_title, book_author, book_publisher, book_price, book_pubdate)"
				+ "values(?, ?, ?, ?, ?, ?)";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, title);
		pstmt.setString(3, author);
		pstmt.setString(4, publisher);
		pstmt.setInt(5, price);
		pstmt.setString(6, pubdate);
		int rowCount = pstmt.executeUpdate();
		
		System.out.println(rowCount + "개의 책정보가 저장되었습니다.");
		
		pstmt.close();
		conn.close();
	}
	
	// 삭제할 책번호를 전달받아서 DB에서 책정보를 삭제하는 기능
	public void deleteBooksByNo(int no) throws Exception {
		String sql = "delete from books "
				+ "where book_no = ?";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();
		
		System.out.println(rowCount + "개의 책정보가 삭제되었습니다.");
		
		pstmt.close();
		pstmt.close();
	}
	
	// 책정보를 전달받아서 변경하는 기능
	public void updateBook(int no, String title, String author, String publisher, int price, 
			String pubdate) throws Exception{
		String sql = "update books "
				+ "set "
				+ "book_title = ?, "
				+ "book_author = ?, "
				+ "book_publisher = ?, "
				+ "book_price = ?, "
				+ "book_pubdate = ? "
				+ "where book_no = ? ";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "zxcv1234");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, author);
		pstmt.setString(3, publisher);
		pstmt.setInt(4, price);
		pstmt.setString(5, pubdate);
		pstmt.setInt(6, no);
		int rowCount = pstmt.executeUpdate();
		
		System.out.println(rowCount + "개의 책정보가 변경되었습니다.");
		
		pstmt.close();
		conn.close();
	}
	
	private void printBooks(ResultSet rs) throws Exception {
		while(rs.next()) {
			int no = rs.getInt("book_no");
			String title = rs.getString("book_title");
			String author = rs.getString("book_author");
			String publisher = rs.getString("book_publisher");
			int price = rs.getInt("book_price");
			String pubdate = rs.getString("book_pubdate");
			Date createDate = rs.getDate("book_create_date");
			
			System.out.println("책번호 : " + no);
			System.out.println("첵재목 : " + title);
			System.out.println("저  자 : " + author);
			System.out.println("출판사 : " + publisher);
			System.out.println("가  격 : " + price);
			System.out.println("출판일 : " + pubdate);
			System.out.println("생성일 : " + createDate);
			System.out.println();
		}
	}
}
