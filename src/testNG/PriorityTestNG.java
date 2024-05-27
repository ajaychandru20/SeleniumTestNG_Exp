package testNG;

import org.testng.annotations.Test;

public class PriorityTestNG {
	
	@Test(priority = 1)

	public void cloginTest() {

	System.out.println("Login successful");

	}

	@Test(priority = 2)

	public void bregisterTest() {

	System.out.println("Register successful");

	}

	@Test(priority = 3)

	public void alogoutTest() {

	System.out.println("Logout successful");

	}

}
