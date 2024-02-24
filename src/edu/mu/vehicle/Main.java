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
		
		VehicleManager.getInstance().displayAllCarInformation();
	        
	    VehicleManager.getInstance().displayAllTruckInformation();
	        
	    VehicleManager.getInstance().displayAllSUVInformation();
	        
	    VehicleManager.getInstance().displayAllMotorBikeInformation();
	        
        Truck car = new Truck("Honda", "Accord", 2022, 120000.0, VehicleColor.GRAY, FuelType.DIESEL, 18000, 5.0, 16, 50.0, StartMechanism.KEYSTART);
        VehicleManager.getInstance().addVehicle(car);	
		// Determines vehicle with highest fuel efficiency
		ArrayList<Vehicle> bestFuelEfficiency = VehicleManager.getInstance().getVehicleWithHighestFuelEfficiency(300, 3.25);
		System.out.println("Vehicle(s) with the highest fuel efficiency: ");
		for(Vehicle vehicle : bestFuelEfficiency) {
			System.out.println(vehicle.toString());
		}
			
		// Determines vehicle with lowest fuel efficiency
		ArrayList<Vehicle> worstFuelEfficiency = VehicleManager.getInstance().getVehicleWithLowestFuelEfficiency(300, 3.25);
		System.out.println("Vehicle(s) with the lowest fuel efficiency: ");
		for(Vehicle vehicle : worstFuelEfficiency) {
			System.out.println(vehicle.toString());
		}
			
		double averageFuelEfficiencyOfSUVs = VehicleManager.getInstance().getAverageFuelEfficiencyOfSUVs(300, 3.25);
	        if (averageFuelEfficiencyOfSUVs == -1.0) {
	            System.out.println("\nNo SUVs in the list to calculate average fuel efficiency.");
	        } else {
	            System.out.println("\nAverage Fuel Efficiency of SUVs: " + averageFuelEfficiencyOfSUVs);
	        }
	        

	        
	        Vehicle HighestMaintenance = VehicleManager.getInstance().getVehicleWithHighestMaintenanceCost(300);
	        if (HighestMaintenance != null) {
	        	System.out.println("Vehicle with highest maintenance cost: " + HighestMaintenance.brand + " " + HighestMaintenance.make);
	            System.out.println("Maintenance cost: $" + HighestMaintenance.calculateMaintenanceCost(300) + "0");
	        } else {
	            System.out.println("No vehicles found in the list.");
	        }
	        
	        Vehicle LowestMaintenance = VehicleManager.getInstance().getVehicleWithLowestMaintenanceCost(300);
	        if (LowestMaintenance != null) {
	        	System.out.println("Vehicle with lowest maintenance cost: " + LowestMaintenance.brand + " " + LowestMaintenance.make);
	            System.out.println("Maintenance cost: $" + LowestMaintenance.calculateMaintenanceCost(300) + "0");
	        } else {
	            System.out.println("No vehicles found in the list.");
	        }
	        
	        VehicleManager.getInstance().displayAllVehicleInformation();
	        

	        VehicleManager.getInstance().displayVehicleInformation(car);
	        VehicleManager.getInstance().saveVehicleList();
	        int count = VehicleManager.getInstance().getNumberOfVehiclesByType(Car.class);
	        System.out.println("Car Count: " + count);
	        
	        VehicleManager.getInstance().removeVehicle(car);
	        VehicleManager.getInstance().displayVehicleInformation(car);
	        VehicleManager.getInstance().saveVehicleList();

	        
	        int count2 = VehicleManager.getInstance().getNumberOfVehiclesByType(Car.class);
	        System.out.println("Car Count: " + count2);
	        
	        
        
	}
}
