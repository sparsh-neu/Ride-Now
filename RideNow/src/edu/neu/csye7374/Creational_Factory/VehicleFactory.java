package edu.neu.csye7374.Creational_Factory;

import edu.neu.csye7374.Vehicle;
import edu.neu.csye7374.Creational_Builder.VehicleBuilder;
import edu.neu.csye7374.Creational_Builder.BuilderAPI;

public class VehicleFactory extends AbstractFactory<Vehicle> {
	
	private static VehicleFactory instance=new VehicleFactory(); // Eager Singleton Factory Class
	
	private  VehicleFactory() {
		super();
	}
	
	public synchronized static VehicleFactory getInstance() {
		return instance;
	}

	@Override
	public Vehicle getObject(BuilderAPI<Vehicle> builder) {
		// TODO Auto-generated method stub
		VehicleBuilder vehicleBuilder=(VehicleBuilder)builder;
		return new Vehicle(vehicleBuilder);
	}

}