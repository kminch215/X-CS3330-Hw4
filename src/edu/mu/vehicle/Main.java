package edu.mu.vehicle;

public class Main {

	public static void main(String[] args) {
		VehicleManager.getInstance();
	    
		boolean error = VehicleManager.getInstance().initializeStock();
		if(!error) {
			System.out.println("Error initializing vehicle stock from file");
		}

	}

}
