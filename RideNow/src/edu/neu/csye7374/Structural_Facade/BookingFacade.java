package edu.neu.csye7374.Structural_Facade;

import edu.neu.csye7374.Behavioral_Observer.Booking;
import edu.neu.csye7374.Structural_Decorator.DecoratorAPI;
import edu.neu.csye7374.Structural_Decorator.FullTankDecorator;
import edu.neu.csye7374.VehicleAPI;

public class BookingFacade {
    private VehicleAPI vehicle;

    public BookingFacade() {
        super();
    }

    public BookingFacade(VehicleAPI vehicle) {
        super();
        this.vehicle = vehicle;
    }

    public Booking booking() {
        Booking booking = new Booking();
        DecoratorAPI fullTankedVehicle = new FullTankDecorator(vehicle);
        booking.addVehicle(fullTankedVehicle);
        return booking;
    }

    public BookingFacade setVehicle(VehicleAPI vehicle) {
        this.vehicle = vehicle;
        return this;
    }
}
