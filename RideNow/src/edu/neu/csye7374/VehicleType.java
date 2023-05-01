package edu.neu.csye7374;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum VehicleType {
	Sedan,
	SUV,
	Hatchback,
	Convertible,
	PickupTruck;
	
    public static List<String> getVehicleTypeList(){
        
        return Stream.of(VehicleType.values()).map(VehicleType::name).collect(Collectors.toList());
    }
    
    public static String[] getVehicleTypeArray() {
        
        return Arrays.stream(VehicleType.values()).map(VehicleType::name).toArray(String[]::new);
    }
    
    public static VehicleType getVehicleType(String s) {
    	VehicleType result = null;
    	switch(s.toLowerCase()) {
    	case "SUV":
    		result = VehicleType.SUV;
    		break;
	    case "Hatchback":
	    	result = VehicleType.Hatchback;
	    	break;
		case "Convertible":
			result = VehicleType.Convertible;
			break;
		case "PickupTruck":
			result = VehicleType.PickupTruck;
			break;
		default:
			result = VehicleType.Sedan;
			break;
		}
    	return result;
    }
}
