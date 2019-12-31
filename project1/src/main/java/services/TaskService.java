package services;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import db.DB;
import models.Task; 

public class TaskService {

	public static Task getTask(int taskId) {
		return DB.tasks.get(taskId);
	} 
	
	public static Task addTask(Task t) { 
		 DB.tasks.put(t.getTaskId(), t);
		return null;
	}
	public static  List<Task> listTask() {  
		List<Task> taskList = new ArrayList<Task>();
		Set<Integer> keys = DB.tasks.keySet();
		for(Integer k: keys)
			taskList.add(DB.tasks.get(k));
		return taskList;
	}
	
}
