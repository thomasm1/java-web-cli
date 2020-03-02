package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import model.Person;
import util.JDBCConnection;

public class SQLInjection {
	
	public static Connection conn = JDBCConnection.getConnection();
	
	public static void main(String[] args) {
		
		Person p = new Person();
		Scanner scan = new Scanner(System.in);
		
		try {
			
			Statement s = conn.createStatement();
			
			String username = scan.nextLine();
			
			String password = scan.nextLine();
			
			String sql = "SELECT * FROM person WHERE username = '" + username
					+ "' AND password = '" + password + "'";
			
			System.out.println(sql);
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				p.setUsername(rs.getString("USERNAME"));
				p.setPassword(rs.getString("PASSWORD"));
				System.out.println(p.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
