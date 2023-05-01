package edu.neu.csye7374.Behavioral_State;

public interface BookingStateAPI {

    /*
    * Booking States (in this particular order) :
    * -> Booking is being verified
    * -> Booking has been confirmed
    * -> Vehicle has been rented
    * -> Vehicle has been returned
    * */

    void verificationState();
    void bookingConfirmedState();
    void vehicleRentedState();
    void vehicleReturnedState();
}
