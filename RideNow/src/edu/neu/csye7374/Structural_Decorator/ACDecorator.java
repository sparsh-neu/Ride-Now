package edu.neu.csye7374.Structural_Decorator;

import edu.neu.csye7374.VehicleAPI;

public class ACDecorator extends DecoratorAPI{

    // Decorator adding Air-conditioning feature to the vehicle

    public ACDecorator(VehicleAPI obj) {
        super(obj);
    }

    @Override
    public double getVehiclePrice(){
        return super.getVehiclePrice() + 500.00;
    }

    @Override
    public String vehicleDescription(){
        return super.vehicleDescription() + " -> Added Air Conditioning \n";
    }
}
