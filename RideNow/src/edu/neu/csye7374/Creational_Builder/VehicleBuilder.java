package edu.neu.csye7374.Creational_Builder;

import edu.neu.csye7374.Vehicle;
import edu.neu.csye7374.VehicleType;
import edu.neu.csye7374.ConvertUtility;
import edu.neu.csye7374.Creational_Factory.VehicleFactory;

public class VehicleBuilder implements BuilderAPI<Vehicle>{
	private int vehicleId;
	private String vehicleName;
	private double vehiclePrice;
	private VehicleType vehicleType;
	private String vehicleManufacturer;
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public double getVehiclePrice() {
		return vehiclePrice;
	}
	public void setVehiclePrice(double vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleManufacturer() {
		return vehicleManufacturer;
	}
	public void setVehicleManufacturer(String vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}
	
	public VehicleBuilder(int vehicleId, String vehicleName, double vehiclePrice, VehicleType vehicleType, String vehicleManufacturer) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.vehiclePrice = vehiclePrice;
		this.vehicleType = vehicleType;
		this.vehicleManufacturer=vehicleManufacturer;
	}
	
	public VehicleBuilder(String s) {
		String[] tokens=s.split(",");
		this.vehicleId=ConvertUtility.StringToInt(tokens[0]);
		this.vehicleName=tokens[1];
		this.vehiclePrice=ConvertUtility.StringToDouble(tokens[2]);	
		this.vehicleType=VehicleType.getVehicleType(tokens[3]);
		this.vehicleManufacturer=tokens[4];
	}


	@Override
	public Vehicle build() {
		// TODO Auto-generated method stub
		return VehicleFactory.getInstance().getObject(this);
	}
}
