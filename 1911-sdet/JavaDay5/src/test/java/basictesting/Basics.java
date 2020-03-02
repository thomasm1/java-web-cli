package basictesting;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Basics {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Runs once before everything else.");
	}
	
	@Before
	public void before() {
		System.out.println("Runs before EACH test method.");
	}
	
	@Test
	public void blank() {
		System.out.println("Blank");
	}
	
	//not optional
	@Test
	public void method() {
		//fail("Not yet implemented");
		
		int x = 2 + 3;
		System.out.println("Hello");
		
		String input = "Hello";
		
		Assert.assertTrue(x < 10);
		Assert.assertFalse(x > 10);
		Assert.assertEquals(input, "Hello");
	}

	@After
	public void after() {
		System.out.println("Runs after EACH test method.");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Runs once after everything else.");
	}
}
