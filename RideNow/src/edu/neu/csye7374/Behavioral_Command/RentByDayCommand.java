package edu.neu.csye7374.Behavioral_Command;

import edu.neu.csye7374.Vehicle;

public class RentByDayCommand implements CommandAPI {
    private static RentByDayCommand instance;
    private Vehicle vehicle;

    public RentByDayCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String execute() {
        return this.vehicle.rentVehicleByDay();
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public RentByDayCommand setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }
}