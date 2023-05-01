package edu.neu.csye7374.Structural_Decorator;

import edu.neu.csye7374.VehicleAPI;

public abstract class DecoratorAPI implements VehicleAPI{
    private VehicleAPI vehicleApi;


    public DecoratorAPI(VehicleAPI vehicleApi) {

        this.vehicleApi = vehicleApi;
    }

    public String vehicleDescription(){
        return this.vehicleApi.vehicleDescription();
    }
    public Object getVehicleManufacturer(){
        return this.vehicleApi.getVehicleManufacturer();
    }
    public int totalNoOfVehicles(){
        return this.vehicleApi.totalNoOfVehicles();
    }
    public double getVehiclePrice(){
        return this.vehicleApi.getVehiclePrice();
    }
}
