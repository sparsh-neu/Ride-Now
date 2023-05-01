package edu.neu.csye7374.Structural_Decorator;

import edu.neu.csye7374.VehicleAPI;

public class FullTankDecorator extends DecoratorAPI{

    // Decorator adding Full tank fuel to the vehicle

    public FullTankDecorator(VehicleAPI obj) {
        super(obj);
    }

    @Override
    public double getVehiclePrice(){
        return super.getVehiclePrice() + 100.00;
    }

    @Override
    public String vehicleDescription(){
        return super.vehicleDescription() + "-> Full tank fuel \n";
    }
}
