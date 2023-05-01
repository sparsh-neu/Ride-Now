package edu.neu.csye7374.Behavioral_Command;

import edu.neu.csye7374.Vehicle;

public class RentAsGuestCommand implements CommandAPI {
    private static RentAsGuestCommand instance;
    private Vehicle vehicle;

    public RentAsGuestCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String execute() {
        return this.vehicle.rentVehicleAsGuest();
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public RentAsGuestCommand setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }
}