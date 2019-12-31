package net.thomasmaestas.java.bean0;

public class UserFactory { // cannot be static
	public User createUser(int userId, String name, String dept) {
		System.out.println("Creating with UserFactory.createUser()");
		return new User(userId, name, dept);
	}

}
