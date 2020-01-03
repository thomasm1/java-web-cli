package webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Request;
import services.RequestService;
	
public class RequestWebService {


	public static void addRequest(HttpServletRequest request, HttpServletResponse response) {

//		int reqId = Integer.parseInt(request.getParameter("reqId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		String reqName = request.getParameter("reqName"); 
		String reqType = request.getParameter("reqType"); 
		String reqDesc = request.getParameter("reqDesc"); 
		
		String reqJustify = request.getParameter("reqJustify"); 
		String reqDatetime = request.getParameter("reqDatetime"); 
		String reqPlace = request.getParameter("reqPlace");  
		
		String reqGradeType = request.getParameter("reqGradeType");  
		String reqGradePass = request.getParameter("reqGradePass");  
		double reqAmt = Double.parseDouble(request.getParameter("reqAmt")); 
//		int reqStage = Integer.parseInt(request.getParameter("reqStage"));
		
		// add db using these fields
	 	Request d = new Request(100, userId, reqName, reqType, reqDesc, reqJustify, reqDatetime, reqPlace, reqGradeType, reqGradePass, reqAmt, 0);
		System.out.println("ReqWebServ submit: "+d);

		// Call RequestService to add it.
		RequestService.addReq(d);
 
		try {
			response.getWriter().append("Successfully added data input: " + request.getContextPath());
		} catch (IOException e1) {
			System.out.println("error adding??"+e1);;
//			e1.printStackTrace();
		}  
	}

	public static void getRequest(HttpServletRequest request, HttpServletResponse response) {

		try {
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");
			
		} catch (ClassNotFoundException e1) {
			System.out.println("oops, Driver not found :-O...\n" +e1);
//			e1.printStackTrace();
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id: " + id);

		Request d = RequestService.getReq(id);
		System.out.println(d);

		ObjectMapper om = new ObjectMapper();
		if (d != null) {
			try {
				String requestJSON = om.writeValueAsString(d);
//				response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
				response.getWriter().append(requestJSON);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // ("Served at: ").append(request.getContextPath());
		 
		}
		else {
			try {
				String notFound = "Oops, couldn't find that ID";
				response.getWriter().append(notFound);
			} catch (IOException e) { 
				e.printStackTrace();
			}	
		}
	}
	
	public static void listRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String uid = request.getParameter("userId");
		Integer intId = Integer.parseInt(uid);
		System.out.println("uid="+uid+" intId="+intId); 
		
		if (intId>0) { 
			List<Request> d = RequestService.listReq(intId);
			ObjectMapper om = new ObjectMapper();
			if (d.size()>0) { 
				try {
					String requestJSON = om.writeValueAsString(d);
//					response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
					response.getWriter().append(requestJSON);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // ("Served at: ").append(request.getContextPath());
			} else {
				try {
					response.getWriter().append("No Reimbursement Requests have been made.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (intId == 88888){
			List<Request> dd = RequestService.listReq(); 
			System.out.println(dd);

			ObjectMapper om = new ObjectMapper();
			try {
				String requestJSON = om.writeValueAsString(dd);
//				response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
				response.getWriter().append(requestJSON);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // ("Served at: ").append(request.getContextPath());
		}
	 
	}
}
