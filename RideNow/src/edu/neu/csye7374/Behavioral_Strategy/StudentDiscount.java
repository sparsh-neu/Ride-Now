package edu.neu.csye7374.Behavioral_Strategy;

import edu.neu.csye7374.Vehicle;

public class StudentDiscount implements DiscountStrategyAPI {

	//Strategy to determine discount algorithm for Students

	@Override
	public double discountPrice(Vehicle vehicle) {
		// TODO Auto-generated method stub
		double discountedPrice=vehicle.getVehiclePrice() * 0.75;
		return discountedPrice;				
	}

	@Override
	public String discountDescription(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return "Student Discount Applied : 25% OFF";
	}

}
