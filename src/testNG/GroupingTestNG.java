package testNG;

import org.testng.annotations.Test;

public class GroupingTestNG {

	@Test(groups = { "Car" })
	public void driveCar() {

		System.out.println("driveCar");
	}

	@Test(groups = { "Bike" })
	public void driveBike() {

		System.out.println("driveBike");
	}

	@Test
	public void driveCycle() {
		System.out.println("driveCycle");
	}

	@Test(groups = { "Car" })
	public void buyCar() {
		System.out.println("buyCar");
	}

	@Test
	public void buyBike() {
		System.out.println("buyBike");
	}

	@Test(groups = { "Car" })
	public void crashCar() {
		System.out.println("crashCar");
	}

	@Test
	public void crashCycle() {
		System.out.println("crashCycle");
	}

	@Test
	public void makeLift() {
		System.out.println("makeLift");
	}

	@Test(groups = { "Car" })
	public void driftCar() {
		System.out.println("driftCar");
	}

	@Test(groups = { "Bike" })
	public void driftBike() {
		
		System.out.println("driftBike");
	}

}
