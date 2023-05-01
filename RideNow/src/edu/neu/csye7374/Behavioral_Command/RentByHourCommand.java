package edu.neu.csye7374.Behavioral_Command;

import edu.neu.csye7374.Vehicle;

public class RentByHourCommand implements CommandAPI {
    private static RentByHourCommand instance;
    private Vehicle vehicle;

    public RentByHourCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public String execute() {
        return this.vehicle.rentVehicleByHour();
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public RentByHourCommand setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }
}