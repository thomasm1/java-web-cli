package net.thomasmaestas.java.bean0;

import java.util.HashMap;
import java.util.Map;
 

public class User { 

	private int userId; 
	private String name;
	private String dept;  
	private UserAddress address; 
	
//	public static Map<Integer, Daily> coll = new HashMap<Integer, Daily>();
	private Map<Integer, String> contacts = new HashMap<Integer, String>(); 
	public void setNameIds(Map<Integer, String> contacts) {
		this.contacts = contacts;
	}
	
	public User(int userId, String name, String dept) {
//		super();
		this.userId = userId;
		this.name = name;
		this.dept = dept;
	}
	
	public static User getInstance(int userId, String name, String dept) {
		// typically named factory method returns itself
		System.out.println("Creating with User.getInstance factory method");
		return new User(userId, name, dept);
	}
	
	
	public void onCreate() {
		System.out.println("#on-init# User.onCreate method: " + this);
	}
	
	public void speak() {
		System.out.println("Good Morning");
	} 
	
	public void setAddress(UserAddress address) { // Dependency Injection
		this.address = address;
	}
	public void setDept(String dept) {  //property
		this.dept = dept;
	}
	public void onDestroy() {  // not initiated if on prototype!
							 	// on-destroy only if singleton
		System.out.println("User decommissioned");
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(Map.Entry<Integer, String> entry: contacts.entrySet()) {
			sb.append(entry.getKey() +": "+entry.getValue()+ "\n");
		}
		return "User [ contacts=" + contacts+"\n userId=" + userId + ", name=" + name + ", dept=" + dept + ",   address="
				+ address + "]\n";
	}  

}
