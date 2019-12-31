package webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Task;
import services.TaskService;

public class TaskWebService {

	public static void getTask(HttpServletRequest request, HttpServletResponse response) {
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		System.out.println("taskId: " + taskId);

		Task t = TaskService.getTask(taskId);
		System.out.println(t);

		ObjectMapper om = new ObjectMapper();
		if (t != null) {
			try {
				String taskJSON = om.writeValueAsString(t);
//				response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
				response.getWriter().append(taskJSON);
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

	public static void addTask(HttpServletRequest request, HttpServletResponse response) {

		int taskId = Integer.parseInt(request.getParameter("taskId"));
//		int reqId = Integer.parseInt(request.getParameter("reqId"));
		int currUserId = Integer.parseInt(request.getParameter("currUserId"));
		
		String timeStamp = request.getParameter("timeStamp");
//		String currDocs = request.getParameter("currDocs"); 
//		String updateReason = request.getParameter("updateReason");
//		
//		String updateReqType = request.getParameter("updateReqType"); 
//		String updateGradeType = request.getParameter("updateGradeType"); 
//		String updateGradePass = request.getParameter("updateGradePass");
//		
//		double updateAmt = Double.parseDouble(request.getParameter("updateAmt"));
//		int updateStage = Integer.parseInt(request.getParameter("updateStage")); 
		
		// add db using these fields
//Task t = new Task(taskId, reqId, currUserId, timeStamp, currDocs, updateReason,updateReqType, updateGradeType, updateGradePass, updateAmt, updateStage);

		Task t = new Task(taskId, 0, currUserId, timeStamp, "", "","", "", "", 100.01, 1);

		System.out.println(t);

		// Call TaskService to add it.
		TaskService.addTask(t);
 
		try {
			response.getWriter().append("Successfully added data input: " + request.getContextPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}  
	}

	public static void listTask(HttpServletRequest request, HttpServletResponse response) {
		List<Task> t = TaskService.listTask(); 
		System.out.println(t);

		ObjectMapper om = new ObjectMapper();
		try {
			String taskJSON = om.writeValueAsString(t);
//			response.getWriter().append("\n\n\n Welcome to Subservlet. You are accessing .do File");
			response.getWriter().append(taskJSON);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // ("Served at: ").append(request.getContextPath());
	 
	}
}
