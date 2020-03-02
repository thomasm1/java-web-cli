package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {

	public static Connection conn = null;

	public static Connection getConnection() {
		try {
			if (conn == null) {

				Class.forName("oracle.jdbc.driver.OracleDriver");

				Properties props = new Properties();
				FileInputStream input = new FileInputStream(
						JDBCConnection.class.getClassLoader().getResource("connection.properties").getFile());
				props.load(input);

//				String endpoint = "jdbc:oracle:thin:@ryan1911sdet.chxttewop8dc.us-east-2.rds.amazonaws.com:1521:ORCL";
//				String username = "ryan";
//				String password = "password";

				String endpoint = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");

				conn = DriverManager.getConnection(endpoint, username, password);
				return conn;

			} else {
				return conn;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		Connection conn1 = getConnection();
		Connection conn2 = getConnection();
		Connection conn3 = getConnection();
		Connection conn4 = getConnection();

		System.out.println(conn1);
		System.out.println(conn2);
		System.out.println(conn3);
		System.out.println(conn4);
	}
}
