package servnew;
//import java.time.LocalDateTime;
import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;

import webservice.TaskWebService; 
import webservice.DeptWebService;
import webservice.LoginWebService;
import webservice.UserWebService;
import webservice.RequestWebService;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) {
 
		HttpSession sess = request.getSession();
		sess.setMaxInactiveInterval(3600);

		sess.setAttribute("r-owner", "{'username', 'tom'},{'ordernum','222'}"); 
		System.out.println("RequestHelper: " + sess.getAttribute("r-owner"));
		
		Cookie sessID = new Cookie("sessID", sess.getId());
		System.out.println("Session ID: " + sess.getId()); 
		response.addCookie(sessID);
		
		Cookie c = new Cookie("date","LocalDateTime");
		response.addCookie(c);
		 
//		sess.invalidate(); 
		
		// This method will delegate other methods
		// on a different layer of our application
		// to process the request.

		String uri = request.getRequestURI();
		System.out.println(uri);

//		if (request.getRequestURI().equals("/project1/subforward.do")) {
//			// forward requires a RequestDispatcher
	//
//			RequestDispatcher rd = request.getRequestDispatcher("/Login");
//			try {
//				rd.forward(request, response);
//			} catch (ServletException | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//		}
		switch (uri) {

		case "/project1/login.do": {
// LOGIN USER FORM
			LoginWebService.login(request, response);
//			Object validated2 =  sess.getAttribute("validated");
//			System.out.println(validated2);
			UserWebService.listUser(request, response);
			break;
		}
// ADD USER FORM
		case "/project1/addUser.do": {
			UserWebService.addUser(request, response);
			break;
		} 
		case "/project1/getUser.do": {
			UserWebService.getUser(request, response);
			break;
		}
		case "/project1/listUser.do": {
			UserWebService.listUser(request, response);
			break;
		} 
		
		case "/project1/getTask.do": {
			TaskWebService.getTask(request, response);
			break;
		}
		case "/project1/addTask.do": {
			TaskWebService.addTask(request, response);
			break;
		} 
		case "/project1/listTask.do": {
			TaskWebService.listTask(request, response);
			break;
		} 
		
		case "/project1/getDept.do": {
			DeptWebService.getDept(request, response);
			break;
		}
		case "/project1/addDept.do": {
			DeptWebService.addDept(request, response);
			break;
		} 
		case "/project1/listDept.do": {
			DeptWebService.listDept(request, response);
			break;
		} 
		
		case "/project1/getRequest.do": {
			RequestWebService.getRequest(request, response);
			break;
		}
		case "/project1/addRequest.do": {
			RequestWebService.addRequest(request, response);
			break;
		} 
		case "/project1/listRequest.do": {
			RequestWebService.listRequest(request, response);
			break;
		} 
		 
//		case "/Task/MasterServlet": {
//			System.out.println("In MasterServlet *case*");
//			break;
//		}
		default: {
			try {
				response.sendError(451, "Get off my 451 lawn");
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		}

	}
}
