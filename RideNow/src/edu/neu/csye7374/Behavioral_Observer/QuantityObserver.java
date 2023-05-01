package edu.neu.csye7374.Behavioral_Observer;

import edu.neu.csye7374.Structural_Facade.DeliveryType;

public class QuantityObserver implements BookingObserver {

    public void updated(Booking booking) {
        if(booking.getDeliveryType() == DeliveryType.Delivery) {
            int count=booking.getVehicleCount();
            double total = booking.getVehicleCount();
            if(count<=2) {
                booking.setDeliveryCost(10);
            }else  {
                booking.setDeliveryCost(10 + (count-2)*2.5);
            }
        }
    }
}
