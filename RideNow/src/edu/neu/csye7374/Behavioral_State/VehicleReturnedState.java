package edu.neu.csye7374.Behavioral_State;

import edu.neu.csye7374.Behavioral_Observer.Booking;
import edu.neu.csye7374.Vehicle;

public class VehicleReturnedState implements BookingStateAPI {

    // Booking State : Vehicle has been returned

    private Booking booking;

    public VehicleReturnedState(Booking booking) {
        super();
        this.booking = booking;
    }

    @Override
    public void verificationState() {
        booking.setState(booking.getVerificationState());
        System.out.println("SUCCESS - Verification has been initiated!!");
    }

    @Override
    public void bookingConfirmedState() {
        System.err.println("ERROR - Vehicle has been returned already!!");
    }

    @Override
    public void vehicleRentedState() {
        System.err.println("ERROR - Vehicle has been returned already!!");
    }

    @Override
    public void vehicleReturnedState() {
        System.err.println("ERROR - Vehicle has been returned already!!");
    }
}
