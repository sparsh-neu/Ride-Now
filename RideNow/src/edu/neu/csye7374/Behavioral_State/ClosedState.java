package edu.neu.csye7374.Behavioral_State;

import edu.neu.csye7374.Garage;

public class ClosedState implements GarageStateAPI {

    // Garage State : Close

    private static Garage garage;

    public ClosedState(Garage garage) {
        super();
        this.garage = garage;
    }

    @Override
    public void stateOpen() {
        garage.setState(garage.getOpenState());
        System.out.println("SUCCESS - Garage state is changed to Open state!!");

    }

    @Override
    public void stateClose() {
        System.err.println("ERROR - Garage is closed already!!");
    }

    @Override
    public void stateStock() {
        garage.setState(garage.getStockState());
        System.out.println("SUCCESS - Garage state is changed to Stock state!!");

    }
}
