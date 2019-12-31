package webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.User;
import services.UserService;

public class UserWebService {

	public static void addUser(HttpServletRequest request, HttpServletResponse response) {

		try {
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");
			
		} catch (ClassNotFoundException e1) {
			System.out.println("oops, Driver not found :-O...\n" +e1);
//			e1.printStackTrace();
		}
//		int userId = Integer.parseInt(request.getParameter("id"));
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		int superId = Integer.parseInt(request.getParameter("superId"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

//		 add db using these fields 
		User d = new User(99, deptId, superId, userName, password, email);
		System.out.println("UserWebService: "+d);

		// Call UserService to add it.
		UserService.addUser(d);

		try {
			response.getWriter().append("Successfully added data to ORACLE (AWS) input: " + request.getContextPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void getUser(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id: " + id);

		User d = UserService.getUser(id);
		System.out.println(d);

		ObjectMapper om = new ObjectMapper();
		if (d != null) {
			try {
				String userJSON = om.writeValueAsString(d);
//				response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
				response.getWriter().append(userJSON);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // ("Served at: ").append(request.getContextPath());

		} else {
			try {
				String notFound = "Oops, couldn't find that ID";
				response.getWriter().append(notFound);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

//	int userId, int deptId, int superId, String userName, String password, String email  

	public static void listUser(HttpServletRequest request, HttpServletResponse response) {
		List<User> d = UserService.listUser();
		System.out.println(d);

		ObjectMapper om = new ObjectMapper();
		try {
			String userJSON = om.writeValueAsString(d);
//			response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
			response.getWriter().append(userJSON);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // ("Served at: ").append(request.getContextPath());

	}
}
