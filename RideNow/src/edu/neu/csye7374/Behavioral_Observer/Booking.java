package edu.neu.csye7374.Behavioral_Observer;

import edu.neu.csye7374.Behavioral_State.*;
import edu.neu.csye7374.Structural_Facade.DeliveryType;
import edu.neu.csye7374.VehicleAPI;

import java.util.ArrayList;
import java.util.List;

public class Booking implements BookingStateAPI {

    private int id;

    private double bookingCost=0;

    private int count=0;

    private double discount=0;

    private double deliveryCost;
    private List<VehicleAPI> vehicleList = new ArrayList<>();
    private DeliveryType deliveryType;
    private static int counter=0;
    private List<BookingObserver> observers = new ArrayList<>();
    {
        observers.add(new PriceObserver());
        observers.add(new QuantityObserver());
    }

    private BookingStateAPI verificationState = new VerificationState(this);
    private BookingStateAPI bookingConfirmedState = new BookingConfirmedState(this);
    private BookingStateAPI vehicleRentedState = new VehicleRentedState(this);
    private BookingStateAPI vehicleReturnedState = new VehicleReturnedState(this);
    private BookingStateAPI state;



    public Booking() {
        super();
        this.id = ++counter;
        this.deliveryType = DeliveryType.Pickup;
        this.state = getVerificationState();
    }


    public Booking(double bookingCost, int count, double deliveryCost, DeliveryType deliveryType) {
        super();
        this.id = ++counter;
        this.bookingCost = bookingCost;
        this.count = count;
        this.deliveryType = deliveryType;

        if(deliveryType==DeliveryType.Pickup) {
            this.deliveryCost = 0;
        }else {
            this.deliveryCost = deliveryCost;
        }
        this.state = getVerificationState();
    }


    public void addVehicle(VehicleAPI vehicle) {
        vehicleList.add(vehicle);
        bookingCost += vehicle.getVehiclePrice();
        count++;
        observers.forEach(observer -> observer.updated(this));
    }

    public boolean removeVehicle(VehicleAPI vehicle) {
        if(vehicleList.remove(vehicle)) {
            return true;
        }
        return false;
    }




    public BookingStateAPI getVerificationState() {
        return this.verificationState;
    }


    public void setVerificationState(BookingStateAPI verificationState) {
        this.verificationState = verificationState;
    }


    public BookingStateAPI getBookingConfirmedState() {
        return this.bookingConfirmedState;
    }


    public void setBookingConfirmedState(BookingStateAPI bookingConfirmedState) {
        this.bookingConfirmedState = bookingConfirmedState;
    }


    public BookingStateAPI getVehicleRentedState() {
        return this.vehicleRentedState;
    }


    public void setVehicleRentedState(BookingStateAPI vehicleRentedState) {
        this.vehicleRentedState = vehicleRentedState;
    }


    public BookingStateAPI getVehicleReturnedState() {
        return vehicleReturnedState;
    }


    public void setVehicleReturnedState(BookingStateAPI vehicleReturnedState) {
        this.vehicleReturnedState = vehicleReturnedState;
    }


    public BookingStateAPI getState() {
        return this.state;
    }


    public void setState(BookingStateAPI state) {
        this.state = state;
    }


    public List<VehicleAPI> getVehicleList() {
        return vehicleList;
    }


    public void setVehicleList(List<VehicleAPI> vehicleList) {
        this.vehicleList = vehicleList;
    }


    public String getVehicleListString() {
        StringBuilder sb = new StringBuilder();
        for(VehicleAPI vehicle : vehicleList) {
            sb.append(vehicle);
            sb.append("; ");
        }
        return sb.toString();
    }


    public DeliveryType getDeliveryType() {
        return deliveryType;
    }


    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }


    public static int getCounter() {
        return counter;
    }


    public static void setCounter(int counter) {
        Booking.counter = counter;
    }


    public List<BookingObserver> getObservers() {
        return this.observers;
    }


    public void setObservers(List<BookingObserver> observers) {
        this.observers = observers;
    }


    public void setCount(int count) {
        this.count = count;
    }


    public double getBookingCost() {
        return this.bookingCost;
    }

    public void attach(BookingObserver observer) {
        this.observers.add(observer);
    }

    public void detach(BookingObserver observer) {
        this.observers.remove(observer);
    }

    public Booking(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return (this.bookingCost + this.deliveryCost) - this.discount;
    }

    public void setBookingCost(double bookingCost) {
        this.bookingCost = bookingCost;
    }

    public int getVehicleCount() {
        return vehicleList.size();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDeliveryCost() {
        return this.deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    @Override
    public String toString() {
        return "Booking Details are as follows: \n[Id=" + id + ", Total Cost=" + this.bookingCost + ", count=" + this.count + ", discount=" + this.discount
                + ", deliveryCost=" + this.deliveryCost+ "]\n";
    }
    @Override
    public void verificationState() {
        this.state.verificationState();
    }

    @Override
    public void bookingConfirmedState() {
        this.state.bookingConfirmedState();
    }

    @Override
    public void vehicleRentedState() {
        this.state.vehicleRentedState();
    }

    @Override
    public void vehicleReturnedState() {
        this.state.vehicleReturnedState();
    }
}

