package edu.neu.csye7374.Behavioral_State;

import edu.neu.csye7374.Behavioral_Observer.Booking;
import edu.neu.csye7374.Vehicle;

public class VerificationState implements BookingStateAPI{

    // Booking State : Booking is being verified
    private Booking booking;

    public VerificationState(Booking booking) {
        super();
        this.booking = booking;
    }

    @Override
    public void verificationState() {
        System.err.println("ERROR - Already in Verification State!!");
    }

    @Override
    public void bookingConfirmedState() {
        booking.setState(booking.getBookingConfirmedState());
        System.out.println("SUCCESS - Booking confirmed!!");
    }

    @Override
    public void vehicleRentedState() {
        System.err.println("ERROR - Booking confirmation pending!!");
    }

    @Override
    public void vehicleReturnedState() {
        System.err.println("ERROR - Booking confirmation is pending OR Vehicle hasn't been rented yet!!");
    }
}
