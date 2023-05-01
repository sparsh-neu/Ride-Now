package edu.neu.csye7374.Behavioral_Strategy;

import edu.neu.csye7374.Vehicle;

public class EmployeeDiscount implements DiscountStrategyAPI{

	//Strategy to determine discount algorithm for Employees

	@Override
	public double discountPrice(Vehicle vehicle) {
		// TODO Auto-generated method stub
		double discountedPrice=vehicle.getVehiclePrice() * 0.85;
		return discountedPrice;	
	}

	@Override
	public String discountDescription(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return "Employee Discount Applied : 15% OFF";
	}

}
