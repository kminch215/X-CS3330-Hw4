package edu.mu.vehicle;

public class Main {

	public static void main(String[] args) {
		VehicleManager.getInstance();
	    
	    boolean error = VehicleManager.getInstance().readFromFile("vehicleList.csv");
	    if(!error) {
	    	System.out.println("readFromFile unsuccessful");
	    }

	}

}
