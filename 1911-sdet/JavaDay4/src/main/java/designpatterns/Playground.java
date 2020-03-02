package designpatterns;

public class Playground {

	public static void main(String[] args) {
		
		//This is not allowed, becase the constructor is private
		//Connection conn = new Connection("Connection1", 15);
		
		Connection conn1 = Connection.getConnection("Connection1", 42);
		System.out.println(conn1);
		
		Connection conn2 = Connection.getConnection("Connection2", 43);
		System.out.println(conn2);
		
		System.out.println(conn1 == conn2);
		conn1.id = 100;
		
		System.out.println(conn1.id);
		System.out.println(conn2.id);
	}
}
