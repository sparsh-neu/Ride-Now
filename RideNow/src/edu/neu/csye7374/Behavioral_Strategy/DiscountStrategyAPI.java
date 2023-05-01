package edu.neu.csye7374.Behavioral_Strategy;

import edu.neu.csye7374.Vehicle;

public interface DiscountStrategyAPI {
    double discountPrice(Vehicle vehicle);
    String discountDescription(Vehicle vehicle);
}