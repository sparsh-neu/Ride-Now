package edu.neu.csye7374.Structural_Facade;

public enum DeliveryType {
    Delivery,
    Pickup;

    public static DeliveryType getDeliveryType(String s) {
        DeliveryType result = null;
        switch(s.toLowerCase()) {
            case "delivery":
                result = DeliveryType.Delivery;
                break;
            case "pickup":
                result = DeliveryType.Pickup;
                break;
            default:
                result = DeliveryType.Pickup;
                break;
        }
        return result;
    }
}
