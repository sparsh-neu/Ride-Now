package edu.neu.csye7374;

public class ConvertUtility {
	
	public static String[] stringSplit(String str) {
        String[] word = str.split(",");

        return word;
    }


	public static double StringToDouble(String s) {
        double number = 0;

        try {
            number = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            System.err.println("ERROR!! Please provide valid floating input for String "+s);
            e.printStackTrace();
        }
        return number;
    }
	

	public static int StringToInt(String s) {
        int number = 0;

        try {
            number = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.err.println("ERROR!! Please provide valid numerical input for String "+s);
            e.printStackTrace();
        }
        return number;
    }    
}
