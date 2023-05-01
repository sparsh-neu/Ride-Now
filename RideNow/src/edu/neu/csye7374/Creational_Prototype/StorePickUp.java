package edu.neu.csye7374.Creational_Prototype;

public class StorePickUp extends DeliveryType {

	public StorePickUp(int deliveryId, String deliveryType, double deliveryCost) {
		super(deliveryId, deliveryType, deliveryCost);
		// TODO Auto-generated constructor stub
	}

	@Override
	String delivertDescription() {
		// TODO Auto-generated method stub
		return "Vehicle ready to be picked-up from the Garage";
	}

}
