package edu.neu.csye7374.Structural_Decorator;

import edu.neu.csye7374.VehicleAPI;

public class BumperToBumperInsuranceDecorator extends DecoratorAPI{

    // Decorator adding Bumper-to-Bumper feature to the vehicle

    public BumperToBumperInsuranceDecorator(VehicleAPI obj) {
        super(obj);
    }

    @Override
    public double getVehiclePrice(){
        return super.getVehiclePrice() + 250.00;
    }

    @Override
    public String vehicleDescription(){
        return super.vehicleDescription() + " -> Added Bumper To Bumper Insurance \n";
    }
}
