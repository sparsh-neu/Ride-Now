package edu.neu.csye7374.Behavioral_State;

import edu.neu.csye7374.Behavioral_Observer.Booking;
import edu.neu.csye7374.Vehicle;

public class BookingConfirmedState implements BookingStateAPI {

    // Booking State : Booking has been confirmed

    private Booking booking;

    public BookingConfirmedState(Booking booking) {
        super();
        this.booking = booking;
    }

    @Override
    public void verificationState() {
        System.err.println("ERROR - Booking is already confirmed!!");
    }

    @Override
    public void bookingConfirmedState() {
        System.err.println("ERROR - Booking is already confirmed!!");
    }

    @Override
    public void vehicleRentedState() {
        booking.setState(booking.getVehicleRentedState());
        System.out.println("SUCCESS - Vehicle is successfully rented!!");
    }

    @Override
    public void vehicleReturnedState() {
        System.err.println("ERROR - Vehicle hasn't been rented yet!!");
    }
}
