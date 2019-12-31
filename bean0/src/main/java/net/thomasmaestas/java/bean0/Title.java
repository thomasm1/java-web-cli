package net.thomasmaestas.java.bean0;

import java.util.HashMap;
import java.util.Map;

public class Title {
	private String name;
	private String dept; 

	private Map<String, String> tasks = new HashMap<String, String>();
	private Map<String, Department> departments = new HashMap<String, Department>();
	
	public void setTasks(Map<String, String> tasks) {
		this.tasks = tasks;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Map.Entry<String, String> entry: tasks.entrySet()) {
			sb.append(entry.getKey() +": "+entry.getValue()+ "\n");
		}
		
		return "Title [name=" + name + ", dept=" + dept + "\n"
				+ "Tasks="+ sb.toString() +"]";
	}
}
