package edu.neu.csye7374;

import edu.neu.csye7374.Behavioral_Command.*;
import edu.neu.csye7374.Behavioral_Observer.Booking;
import edu.neu.csye7374.Behavioral_State.ClosedState;
import edu.neu.csye7374.Behavioral_State.GarageStateAPI;
import edu.neu.csye7374.Behavioral_State.OpenState;
import edu.neu.csye7374.Behavioral_State.StockState;
import edu.neu.csye7374.Behavioral_Strategy.*;
import edu.neu.csye7374.Creational_Builder.EmployeeBuilder;
import edu.neu.csye7374.Creational_Builder.VehicleBuilder;
import edu.neu.csye7374.Creational_Factory.EmployeeFactory;
import edu.neu.csye7374.Creational_Factory.VehicleFactory;
import edu.neu.csye7374.Structural_Adapter.*;
import edu.neu.csye7374.Structural_Decorator.ACDecorator;
import edu.neu.csye7374.Structural_Decorator.BabySeatDecorator;
import edu.neu.csye7374.Structural_Decorator.BumperToBumperInsuranceDecorator;
import edu.neu.csye7374.Structural_Decorator.ThirdPartyInsuranceDecorator;
import edu.neu.csye7374.Structural_Facade.BookingFacade;
import edu.neu.csye7374.Structural_Facade.DeliveryType;

import java.util.*;

public class Garage implements GarageStateAPI {

    private String name;
    private List<Vehicle> vehicleList = new ArrayList<>();
    private List<Person> listOfPerson = new ArrayList<>();
    public static DiscountStrategy strategy = DiscountStrategy.NONE;
    private GarageStateAPI openState = new OpenState(this);
    private GarageStateAPI stockState = new StockState(this);
    private GarageStateAPI closeState = new ClosedState(this);
    private GarageStateAPI state;


    private static Map<DiscountStrategy, DiscountStrategyAPI> strategyMap = new HashMap<>();
    {
        strategyMap.put(DiscountStrategy.StudentDiscount, new StudentDiscount());
        strategyMap.put(DiscountStrategy.EmployeeDiscount, new EmployeeDiscount());
        strategyMap.put(DiscountStrategy.MemberDiscount, new MemberDiscount());
    }

    public Garage(String name) {
        super();
        this.name = name;
        this.state = getOpenState();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setItemList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Person> getListOfPerson() {
        return listOfPerson;
    }

    public void setListOfPerson(List<Person> listOfPerson) {
        this.listOfPerson = listOfPerson;
    }

    public static DiscountStrategy getStrategy() {
        return strategy;
    }

    public static void setStrategy(DiscountStrategy strategy) {
        Garage.strategy = strategy;
    }

    public static Map<DiscountStrategy, DiscountStrategyAPI> getstrategyMap() {
        return strategyMap;
    }

    public static void setStrategyMap(Map<DiscountStrategy, DiscountStrategyAPI> strategyMap) {
        Garage.strategyMap = strategyMap;
    }

    public GarageStateAPI getState() {
        return state;
    }

    public void setState(GarageStateAPI state) {
        this.state = state;
    }

    public GarageStateAPI getOpenState() {
        return openState;
    }

    public void setOpenState(GarageStateAPI openState) {
        this.openState = openState;
    }

    public GarageStateAPI getStockState() {
        return stockState;
    }

    public void setStockState(GarageStateAPI stockState) {
        this.stockState = stockState;
    }

    public GarageStateAPI getCloseState() {
        return closeState;
    }

    public void setCloseState(GarageStateAPI closeState) {
        this.closeState = closeState;
    }

    @Override
    public void stateOpen() {
        this.state.stateOpen();

    }

    @Override
    public void stateClose() {
        this.state.stateClose();
    }

    @Override
    public void stateStock() {
        this.state.stateStock();
    }

    public static void demo() {

        List<Vehicle> vehicleList = new ArrayList<>();

        //Builder, Factory and Singleton Pattern
        System.out.println("*********************************************************************************************************************");
        System.out.println("Demonstration of Builder pattern, Factory and Singleton patterns.\nCreate only single instance of Vehicle Builder object using Factory and singleton pattern");
        VehicleBuilder vehicleBuilder = new VehicleBuilder(1, "RAV4", 2610, VehicleType.SUV, "Toyota");
        VehicleAPI vehicle = VehicleFactory.getInstance().getObject(vehicleBuilder);
        vehicleList.add((Vehicle) vehicle);
        System.out.println(vehicle);

        vehicleBuilder = new VehicleBuilder(2, "K5", 2468, VehicleType.Sedan, "Kia");
        vehicle = VehicleFactory.getInstance().getObject(vehicleBuilder);
        vehicleList.add((Vehicle)vehicle);

        vehicleBuilder = new VehicleBuilder(3, "Mustang", 3305, VehicleType.Convertible, "Ford");
        vehicle = VehicleFactory.getInstance().getObject(vehicleBuilder);
        vehicleList.add((Vehicle)vehicle);


        vehicleBuilder = new VehicleBuilder(4, "Veloster", 1990, VehicleType.Hatchback, "Hyundai");
        vehicle = VehicleFactory.getInstance().getObject(vehicleBuilder);
        vehicleList.add((Vehicle)vehicle);


        vehicleBuilder = new VehicleBuilder(5, "Silverado 1500", 2930, VehicleType.PickupTruck, "Chevrolet");
        vehicle = VehicleFactory.getInstance().getObject(vehicleBuilder);
        vehicleList.add((Vehicle)vehicle);


        vehicleBuilder = new VehicleBuilder(6, "Accord", 2550, VehicleType.Sedan, "Honda");
        vehicle = VehicleFactory.getInstance().getObject(vehicleBuilder);
        vehicleList.add((Vehicle)vehicle);

        //Prototype Pattern to clone the object of manufacturer
        System.out.println("*********************************************************************************************************************");
        System.out.println("Demonstration of Prototype pattern to clone the object of Manufacturer");
        Manufacturer manufacturer = Manufacturer.getInstance().clone();
        manufacturer.setManufacturerName("Ford")
                .setYearEstablished(1903);
        System.out.println(manufacturer);

        //Adapter Pattern to adapt vehicle with manufacturer
        ManufacturerObjectAdapter adapter = new ManufacturerObjectAdapter(vehicle);

        System.out.println("*********************************************************************************************************************");
        System.out.println("Below is manufacturer name calling with legacy Vehicle object.");
        System.out.println(vehicle.getVehicleManufacturer());
        System.out.println("Demonstration of Adapter pattern by showing the manufacturer name calling with adapter object.");
        System.out.println(adapter.getManufacturerName());
        System.out.println("*********************************************************************************************************************");

        //Command Pattern
        System.out.println("Demonstration of Command pattern to rent by day/hour/AsGuest/AsMember");
        CommandInvoker invoker = CommandInvoker.getInstance();
        invoker.setCommand(new RentByDayCommand((Vehicle) vehicle));
        System.out.println(invoker.invoke());
        invoker.setCommand(new RentByHourCommand((Vehicle) vehicle));
        System.out.println(invoker.invoke());
        invoker.setCommand(new RentAsGuestCommand((Vehicle) vehicle));
        System.out.println(invoker.invoke());
        invoker.setCommand(new MembershipCommand((Vehicle) vehicle));
        System.out.println(invoker.invoke());
        System.out.println("*********************************************************************************************************************");

        //Demonstration of facade pattern and decorator pattern
        System.out.println("Demonstration of Facade and Decorator pattern - using different types of decorator which alters the total price.\nAlso demonstrate the Observer pattern which notifies the observer when any vehicle gets added to the booking list");
        BookingFacade facade = new BookingFacade(vehicleList.get(0));
        Booking booking = facade.booking();
        booking.setDeliveryType(DeliveryType.Delivery);
        System.out.println(booking);

        booking.addVehicle(new ThirdPartyInsuranceDecorator(vehicleList.get(1)));
        System.out.println(booking);
        booking.addVehicle(new BabySeatDecorator(vehicleList.get(2)));
        System.out.println(booking);
        booking.addVehicle(new BumperToBumperInsuranceDecorator(vehicleList.get(3)));
        System.out.println(booking);
        booking.addVehicle(new ACDecorator(vehicleList.get(4)));
        System.out.println(booking);
        System.out.println("*********************************************************************************************************************");

        //State Pattern
        System.out.println("Demonstration of state pattern shows the transitions from verification to returned state");

        booking.getState().verificationState();
        booking.getState().vehicleRentedState();
        booking.getState().bookingConfirmedState();
        booking.getState().vehicleReturnedState();
        booking.getState().vehicleRentedState();
        booking.getState().vehicleReturnedState();
        System.out.println("*********************************************************************************************************************");

        //Strategy Pattern
        System.out.println("Demonstration of strategy pattern to show different discounts applied to original price and final price after student, employee and member discounts ");
        Garage garage = new Garage("RideNow");
        EmployeeBuilder empBuilder = new EmployeeBuilder(1,30,"John","Doe",20);
        Employee emp = EmployeeFactory.getInstance().getObject(empBuilder);
        System.out.println("Using Factory and singleton pattern to get only single instance of Employee Builder object");
        System.out.println(emp);
        System.out.println("*********************************************************************************************************************");

        System.out.println("Vehicle before discount: \n"+ vehicle);

        double price=0;
        for(DiscountStrategy strategy : Garage.getstrategyMap().keySet()){
            garage.setStrategy(strategy);
            price = ((Vehicle)vehicle).runStrategy();
            System.out.println("Vehicle price after discount: " + Garage.getstrategyMap().get(strategy).discountDescription((Vehicle) vehicle) + " , " + price);
        }
        System.out.println("*********************************************************************************************************************");
    }
}

