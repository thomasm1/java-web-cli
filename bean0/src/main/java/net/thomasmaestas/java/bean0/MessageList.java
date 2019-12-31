package net.thomasmaestas.java.bean0;
 
import java.util.List;

public class MessageList {
	private String name;
	private List<String> messages;
	
	public MessageList(String name, List<String> messages) {
		this.name = name;
		this.messages = messages;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(name);
		sb.append(" contains:\n");
		
		for(String message: messages) {
			sb.append(message);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
