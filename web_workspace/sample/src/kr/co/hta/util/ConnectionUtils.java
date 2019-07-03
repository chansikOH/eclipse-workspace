package kr.co.hta.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtils {

	public static Connection hrConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		
		return DriverManager.getConnection(url, user, password);
	}
}
