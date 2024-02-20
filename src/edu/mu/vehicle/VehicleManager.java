package edu.mu.vehicle;

import java.util.ArrayList;

public class VehicleManager {

	private final static String vehicleFilePath = "vehicleList.csv";
	
	private static VehicleManager instance;
    private ArrayList<Vehicle> list = null;
	
	public static VehicleManager getInstance() {
        if(instance == null)
            instance = new VehicleManager();

        return instance;
    }
	
	 private VehicleManager() {
        list = new ArrayList<Vehicle>();
      }
	 
    public ArrayList<Vehicle> getArray() {
       return this.list;
     }
}
