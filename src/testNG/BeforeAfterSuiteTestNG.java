package testNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BeforeAfterSuiteTestNG {

	 @BeforeSuite
	    public void setUp() {
	        // Initialize resources or perform setup operations
	        System.out.println("Before Suite: Initializing resources...");
	    }

	    @AfterSuite
	    public void tearDown() {
	        // Teardown operations or cleanup
	        System.out.println("After Suite: Cleaning up resources...");
	    }

	    @Test
	    public void test2() {
	        System.out.println("Test 1");
	        
	    }

	    @Test
	    public void test1() {
	        System.out.println("Test 2");
	    }
}
