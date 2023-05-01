package edu.neu.csye7374;

import edu.neu.csye7374.Behavioral_Command.*;
import edu.neu.csye7374.Creational_Builder.VehicleBuilder;

public class RideNow {
    public static void demo(){
        CommandInvoker invoker = CommandInvoker.getInstance();
        VehicleBuilder vehicleBuilder = new VehicleBuilder(1234, "Mustang", 25000, VehicleType.Convertible, "Ford");
        Vehicle vehicle = vehicleBuilder.build();
        invoker.setCommand(new RentByDayCommand(vehicle));
        System.out.println(invoker.invoke());
        invoker.setCommand(new RentByHourCommand(vehicle));
        System.out.println(invoker.invoke());
        invoker.setCommand(new RentAsGuestCommand(vehicle));
        System.out.println(invoker.invoke());
        invoker.setCommand(new MembershipCommand(vehicle));
        System.out.println(invoker.invoke());
    }
}
