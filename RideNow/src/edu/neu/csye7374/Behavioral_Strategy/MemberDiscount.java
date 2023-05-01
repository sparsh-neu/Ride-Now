package edu.neu.csye7374.Behavioral_Strategy;

import edu.neu.csye7374.Vehicle;

public class MemberDiscount implements DiscountStrategyAPI {

	//Strategy to determine discount algorithm for Ride-Now Members exclusively

	@Override
	public double discountPrice(Vehicle vehicle) {
		// TODO Auto-generated method stub
		double discountedPrice= vehicle.getVehiclePrice() * 0.70;
		return discountedPrice;	
	}

	@Override
	public String discountDescription(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return "Member Discount Applied : 30% OFF";
	}

}
