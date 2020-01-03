package webservice;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.fasterxml.jackson.databind.ObjectMapper;

import models.User;
import services.UserService;

public class LoginWebService {

	public static void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");

		} catch (ClassNotFoundException e1) {
			System.out.println("oops, Driver not found :-O...\n" + e1);
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username1: " + username + "; password1: " + password);
		int dbId = 0;
		String dbUser = null;
		int dbSuper = 0;
		int dbDept = 0;
		
		List<User> uu = UserService.listUser();
		Boolean valid = false;
		for (User u : uu) {
			if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
				System.out.println("logged in! " + u.getUserName() + " matches " + username + "\n" + "and "
						+ u.getPassword() + " matches " + password + " :-)... welcome");
				valid = true;
				User user = UserService.getUser(u.getUserId());
				System.out.println(user.toString());
				;
				dbUser = user.getUserName();
				dbId = user.getUserId();
				dbSuper = user.getSuperId();
				dbDept = u.getDeptId();
				System.out.println("dbDept: " + dbDept + ", passes validation: " + valid);
			}

		}
		System.out.println("if valid.." + valid);
		if (valid) {

			HttpSession sess = request.getSession();
			sess.setAttribute("sessionId", sess.getId());
			sess.setAttribute("username", username);
			sess.setAttribute("validated", "validated");
			System.out.println("User: " + username + " is validated: " + valid);

			request.setAttribute("dbUser", dbUser);
			request.setAttribute("dbId", dbId);
			request.setAttribute("dbSuper", dbSuper);
			request.setAttribute("dbDept", dbDept);

			response.setContentType("text/html");
			Cookie sessUser = new Cookie("sessUser", dbUser);
			Cookie sessId = new Cookie("sessId", Integer.toString(dbId));
			Cookie sessSuper = new Cookie("sessSuper", Integer.toString(dbSuper));
			Cookie sessDept = new Cookie("sessDept", Integer.toString(dbDept));
			response.addCookie(sessId);
			response.addCookie(sessUser);
			response.addCookie(sessSuper);
			response.addCookie(sessDept);
			System.out.println("..just made cookies...");

			RequestDispatcher rd = request.getRequestDispatcher("/project1/index.html");
			rd.forward(request, response);

		} else {
			System.out.println("failed validation");
			RequestDispatcher rdd = request.getRequestDispatcher("/index.html");
			rdd.forward(request, response);
			request.setAttribute("errorMessage", "Oops, invalid credentials, typo maybe?");
		}

	}
 

}
