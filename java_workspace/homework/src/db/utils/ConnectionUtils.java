package db.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtils {

	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@192.168.10.254:1521:xe";
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hta";
//		String user = "hr";
		String password = "zxcv1234";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}
}
