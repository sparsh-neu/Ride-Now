package edu.neu.csye7374.Behavioral_State;

import edu.neu.csye7374.Garage;

public class OpenState implements GarageStateAPI {

    // Garage State : Open

    private static Garage garage;

    public OpenState(Garage garage) {
        super();
        this.garage=garage;
    }

    @Override
    public void stateOpen() {
        System.err.println("ERROR - Garage is open already!!");
    }

    @Override
    public void stateClose() {
        garage.setState(garage.getCloseState());
        System.out.println("SUCCESS - Garage state is changed to Closed state!!");
    }

    @Override
    public void stateStock() {
        garage.setState(garage.getStockState());
        System.out.println("SUCCESS - Garage state is changed to Stock state!!");
    }
}
