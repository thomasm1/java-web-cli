package basictesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Basics {
//
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//	@BeforeEach
//	void setUp() throws Exception {
//	}

	@Test
	void test1() { 
		System.out.println("newbasictest");
		int x = 2+3;
		Assert.assertTrue(x < 10);
	}
	@Test
	void test2() { 
		System.out.println("newbasictest2");
		int x = 2+3; 
		Assert.assertFalse(x > 10); 
	}
	@Test
	void test3() { 
		System.out.println("newbasictest3"); 
		String input = "hello"; 
		Assert.assertEquals(input, "hello");
	}
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//	@AfterEach
//	void tearDown() throws Exception {
//	}

}
