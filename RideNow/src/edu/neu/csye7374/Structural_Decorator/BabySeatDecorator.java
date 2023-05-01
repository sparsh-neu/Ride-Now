package edu.neu.csye7374.Structural_Decorator;

import edu.neu.csye7374.VehicleAPI;

public class BabySeatDecorator extends DecoratorAPI{

    // Decorator adding Baby-seat feature to the vehicle

    public BabySeatDecorator(VehicleAPI obj) {
        super(obj);
    }

    @Override
    public double getVehiclePrice(){
        return super.getVehiclePrice() + 200.00;
    }

    @Override
    public String vehicleDescription(){
        return super.vehicleDescription() + " -> Added Baby Seat \n";
    }
}
