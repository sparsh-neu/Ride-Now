package edu.neu.csye7374.Behavioral_Command;

import edu.neu.csye7374.Vehicle;

public class MembershipCommand implements CommandAPI {
    private static MembershipCommand instance;
    private Vehicle vehicle;

    public MembershipCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String execute() {
        return this.vehicle.rentVehicleAsMember();
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public MembershipCommand setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }
}