package edu.neu.csye7374.Structural_Adapter;

import edu.neu.csye7374.VehicleAPI;

public class ManufacturerObjectAdapter implements ManufacturerAPI{
    private VehicleAPI vehicleAPI;

    public ManufacturerObjectAdapter(VehicleAPI vehicleAPI) {
        this.vehicleAPI = vehicleAPI;
    }

    @Override
    public String getManufacturerName() {
        return "Manufacturer Name: "+ vehicleAPI.getVehicleManufacturer();
    }
}
