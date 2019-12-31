package webservice;

import java.io.IOException;
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

	public static void login(HttpServletRequest request, HttpServletResponse response) {

		try {
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");
			
		} catch (ClassNotFoundException e1) {
			System.out.println("oops, Driver not found :-O...\n" +e1);
//			e1.printStackTrace();
		}
		HttpSession sessId = request.getSession();   
		sessId.setAttribute("sessId", sessId);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username: " + username + "; password: " + password); 
		Cookie attemptUser = new Cookie("attemptUser", username);
		response.addCookie(attemptUser);
		Cookie validUser = new Cookie("validUser",  "not-validated");
		response.addCookie(validUser);
		boolean validated = isUserValid(username, password); 
		
		if (validated) { 
			HttpSession sess = request.getSession();   
			sess.setAttribute("username", username);
			sess.setAttribute("validated", validated); 
			System.out.println("User: "+username+" is validated: "+validated);
			
			Cookie sessID = new Cookie("updateSID", sess.getId());
			response.addCookie(sessID);
			Cookie sessUser = new Cookie("sessUser", username);
			response.addCookie(sessUser);
//			Cookie validUser = new Cookie("validUser", (String) sess.getAttribute("validated"));
			Cookie validUserTrue = new Cookie("validUser",  "validated");
			response.addCookie(validUserTrue);
//				RequestDispatcher rd = request.getRequestDispatcher("/project1/index.html");
//			try {
//				rd.forward(request, response);
////				response.sendRedirect("/project1/index.html");
//				
//			} catch (ServletException | IOException e) { 
//				e.printStackTrace();
//			}
		} else {
			Cookie validUserFalse = new Cookie("validUser",  "NOTVALID");
			response.addCookie(validUserFalse);
			request.setAttribute("errorMessage", "Oops, invalid credentials, typo maybe?");
			try {
				request.getRequestDispatcher("/project1/login.html").forward(
						request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	public static boolean isUserValid(String username, String password) {
		List<User> uu = UserService.listUser();
		boolean valid = false;
		for (User u : uu) {
			if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
				System.out.println("logged in! " + u.getUserName() + " matches " + username + "\n" + "and "
						+ u.getPassword() + " matches " + password + " :-)... welcome"); 
				valid = true;
				System.out.println(valid);
			}
		}
		return valid;
	}

}
