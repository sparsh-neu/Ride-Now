package edu.neu.csye7374.Behavioral_State;

import edu.neu.csye7374.Behavioral_Observer.Booking;
import edu.neu.csye7374.Vehicle;

public class VehicleRentedState implements BookingStateAPI {

    // Booking State : Vehicle has been rented

    private Booking booking;

    public VehicleRentedState(Booking booking) {
        super();
        this.booking = booking;
    }

    @Override
    public void verificationState() {
        System.err.println("ERROR - Vehicle has been rented already!!");
    }

    @Override
    public void bookingConfirmedState() {
        System.err.println("ERROR - Vehicle has been rented already!!");
    }

    @Override
    public void vehicleRentedState() {
        System.err.println("ERROR - Vehicle has been rented already!!");
    }

    @Override
    public void vehicleReturnedState() {
        booking.setState(booking.getVehicleReturnedState());
        System.out.println("SUCCESS - Vehicle has been returned successfully!!");
    }
}
