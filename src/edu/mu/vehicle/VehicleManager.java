package edu.mu.vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleManager {

	private final static String vehicleFilePath = "vehicleList.csv";
	private final static double distance = 300;
	private final static double fuelPrice = 3.25;
	
	private static VehicleManager instance;
    private ArrayList<Vehicle> vehicleList = null;
	
	public static VehicleManager getInstance() {
        if(instance == null)
            instance = new VehicleManager();

        return instance;
    }
	
	 private VehicleManager() {
        vehicleList = new ArrayList<Vehicle>();
      }
	 
    public ArrayList<Vehicle> getArray() {
       return this.vehicleList;
     }
    
    public boolean initializeStock() {
    	Vehicle vehicle = null;
    	try {
	        File file = new File(vehicleFilePath);
	        Scanner scanner = new Scanner(file);
            
	        if (scanner.hasNextLine()) {
	            scanner.nextLine(); // Skips file header
	        }

	        // Read the data
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] parts = line.split(","); // Assuming the CSV is comma-separated

	            // Access each part of the CSV row
	            String vehicleType = parts[0];
	            String vehicleModel = parts[1];
	            String vehicleMake = parts[2];
	            long modelYear = Long.parseLong(parts[3]);
	            double price = Double.parseDouble(parts[4]);
	            String color = parts[5];
	            VehicleColor enumColor = VehicleColor.valueOf(color);
	            String fuel = parts[6];
	            FuelType fuelType = FuelType.valueOf(fuel);
	            double mileage = Double.parseDouble(parts[7]);
	            double mass = Double.parseDouble(parts[8]);
	            int cylinders = Integer.parseInt(parts[9]); 
	            double gasTankCapacity = Double.parseDouble(parts[10]);
	            String start = parts[11];
	            StartMechanism startMechanism = StartMechanism.valueOf(start);
	            
	            
//	            System.out.println("Type: " + vehicleType + ", Model: " + vehicleModel + ", Make: " + vehicleMake + 
//	            		", Year: " + modelYear + ", Price: " + price + ", Color: " + enumColor + ", Fuel Type: " + fuelType + ", Mileage: " + mileage 
//	            		+ ", Mass: " + mass + ", Cylinders: " + cylinders + ", Gas Tank: " + gasTankCapacity + ", Start Mechansism: " + startMechanism);
//	            
	            if(vehicleType.equals("Car")) {
                	vehicle = new Car(vehicleModel, vehicleMake, modelYear, price, enumColor, fuelType, mileage, mass, cylinders, gasTankCapacity, startMechanism);
                }
                else if(vehicleType.equals("MotorBike"))
                {
                	vehicle = new MotorBike(vehicleModel, vehicleMake, modelYear, price, enumColor, fuelType, mileage, mass, cylinders, gasTankCapacity, startMechanism);
                }
                else if(vehicleType.equals("SUV"))
                {
                	vehicle = new SUV(vehicleModel, vehicleMake, modelYear, price, enumColor, fuelType, mileage, mass, cylinders, gasTankCapacity, startMechanism);
                }
                else if(vehicleType.equals("Truck"))
                {
                	vehicle = new Truck(vehicleModel, vehicleMake, modelYear, price, enumColor, fuelType, mileage, mass, cylinders, gasTankCapacity, startMechanism);
                }
	            
	            VehicleManager.getInstance().addVehicle(vehicle);
	        }
	        scanner.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("File not found: " + vehicleFilePath);
	        e.printStackTrace();
	        return false;
	    }
    	
    	return true;
    }
    
    public boolean addVehicle(Vehicle vehicle) {
		if (!vehicleList.contains(vehicle)) {
			vehicleList.add(vehicle);
			return true;
		}
		return false;
	}
    
//    Calculates the fuel efficiencies for each vehicle in the vehicle list and returns the vehicle
//    with the highest fuel efficiency.
//    If multiple vehicles have the same highest fuel efficiency, returns vehicles with the same
//    highest fuel efficiency in an ArrayList.
    public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice){
    	distance = VehicleManager.distance;
    	fuelPrice = VehicleManager.fuelPrice;
    	ArrayList<Vehicle> myVehicles = new ArrayList<Vehicle>();
    	for(Vehicle vehicle: VehicleManager.getInstance().getArray()) {
    		double fuelEfficiency1 = 0.0;
    		double fuelEfficiency2 = 0.0;
    		Vehicle max = null;
    		if(vehicle instanceof Car) {
    			fuelEfficiency1 =  vehicle.getCylinders() * vehicle.getGasTankCapacity() * fuelPrice / distance * 0.003;
            }
            else if(vehicle instanceof MotorBike)
            {
            	fuelEfficiency1 =  vehicle.getCylinders() * vehicle.getGasTankCapacity() * fuelPrice / distance * 0.001;
            }
            else if(vehicle instanceof SUV)
            {
            	fuelEfficiency1 =  vehicle.getCylinders() * vehicle.getGasTankCapacity() * fuelPrice / distance * 0.05;
            }
            else if(vehicle instanceof Truck)
            {
            	fuelEfficiency1 =  vehicle.getCylinders() * vehicle.getGasTankCapacity() * fuelPrice / distance * 0.1;
            }
    		
    		if(fuelEfficiency1 > fuelEfficiency2) {
    			myVehicles.clear();
    			myVehicles.add(vehicle);
    		}
    		else if(fuelEfficiency1 == fuelEfficiency2) {
    			myVehicles.add(vehicle);
    		}
    		
    		fuelEfficiency2 = fuelEfficiency1;
    		
    	}
		return myVehicles;
    	
    }
}
