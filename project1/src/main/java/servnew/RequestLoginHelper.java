package servnew;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;

import webservice.TaskWebService;
import webservice.DeptWebService;
import webservice.UserWebService;
import webservice.RequestWebService;
import javax.servlet.http.HttpSession;

public class RequestLoginHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) {
		// This method will delegate other methods
		// on a different layer of our application
		// to process the request.

		HttpSession sess = request.getSession();
		System.out.println("Session ID: " + sess.getId());
	
		sess.setMaxInactiveInterval(3600); 
		System.out.println("RequestHelperLogin Login: " + sess.getAttribute("user"));

//		String uri = request.getRequestURI();
//		System.out.println(uri);
//
//		switch (uri) {
//		
//		case "/project1/getUser.do": {
//			UserWebService.getUser(request, response);
//			break;
//		}
//		case "/project1/addUser.do": {
//			UserWebService.addUser(request, response);
//			break;
//		} 
//		case "/project1/listUser.do": {
//			UserWebService.listUser(request, response);
//			break;
//		}  
//		case "/Task/MasterServlet": {
//			System.out.println("In MasterServlet *case*");
//			break;
//		}
//		default: {
//			try {
//				response.sendError(451, "Get off my 451 lawn");
//			} catch (IOException e) {
//				System.out.println(e);
//			}
//		}
//		}

	}
}
