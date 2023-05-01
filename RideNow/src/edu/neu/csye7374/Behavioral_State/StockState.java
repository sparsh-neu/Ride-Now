package edu.neu.csye7374.Behavioral_State;

import edu.neu.csye7374.Garage;

public class StockState implements GarageStateAPI  {

    // Garage State : Stock

    private static Garage garage;

    public  StockState(Garage garage) {
        super();
        this.garage=garage;
    }

    @Override
    public void stateOpen() {
        garage.setState(garage.getOpenState());
        System.out.println("SUCCESS - Garage state is changed to Open state!!");

    }

    @Override
    public void stateClose() {
        garage.setState(garage.getCloseState());
        System.out.println("SUCCESS - Garage state is changed to Closed state!!");
    }

    @Override
    public void stateStock() {
        System.err.println("ERROR - Garage is in stock state already!!");

    }
}

