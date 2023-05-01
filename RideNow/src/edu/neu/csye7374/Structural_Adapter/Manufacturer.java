package edu.neu.csye7374.Structural_Adapter;


public class Manufacturer implements ManufacturerAPI, Cloneable{
    private String manufacturerName;
    private int yearEstablished;
    private static Manufacturer instance;

    public static synchronized Manufacturer getInstance() {
        if (instance == null) {
            instance = new Manufacturer();
        }
        return instance;
    }

    public Manufacturer() {
        super();
    }

    public int getYearEstablished() {
        return yearEstablished;
    }
    public Manufacturer setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
        return this;
    }

    public Manufacturer setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        return this;
    }

    @Override
    public String getManufacturerName() {
        return "Manufacturer Name: "+ this.manufacturerName;
    }
    @Override
    public String toString() {
        return "Manufacturer [manufacturerName=" + manufacturerName + ", yearEstablished=" + yearEstablished + "]";
    }

    @Override
    public Manufacturer clone() {
        Manufacturer clone = null;

        try {
            clone = (Manufacturer)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
