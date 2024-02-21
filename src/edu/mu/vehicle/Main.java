package edu.mu.vehicle;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		VehicleManager.getInstance();
	    
		// Read vehicle data from the vehicleList.csv file and initialize objects.
		boolean error = VehicleManager.getInstance().initializeStock();
		if(!error) {
			System.out.println("Error initializing vehicle stock from file");
		}
		
		// Determines vehicle with highest fuel efficiency
		ArrayList<Vehicle> bestFuelEfficiency = VehicleManager.getInstance().getVehicleWithHighestFuelEfficiency(300, 3.25);
		System.out.println("Vehicle(s) with the highest fuel efficiency: ");
		for(Vehicle vehicle : bestFuelEfficiency) {
			System.out.println(vehicle.toString());
		}
		
//		 Determines vehicle with lowest fuel efficiency
		ArrayList<Vehicle> worstFuelEfficiency = VehicleManager.getInstance().getVehicleWithLowestFuelEfficiency(300, 3.25);
		System.out.println("Vehicle(s) with the lowest fuel efficiency: ");
		for(Vehicle vehicle : worstFuelEfficiency) {
			System.out.println(vehicle.toString());
		}
	}

}
