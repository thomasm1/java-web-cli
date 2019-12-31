package net.thomasmaestas.java.bean0;

import java.util.List;

public class Request {
	private String name;
	private String type;
private List<String> requests;
	
	public Request(String name, List<String> requests) {
		this.name = name;
		this.requests = requests;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
StringBuilder sb = new StringBuilder();
		
		sb.append(name);
		sb.append(" contains:\n");
		
		for(String message: requests) {
			sb.append(message);
			sb.append("\n");
		}
		
		return "Request Types: [name=" + name + ", type=" + type + "]";
	}
}
