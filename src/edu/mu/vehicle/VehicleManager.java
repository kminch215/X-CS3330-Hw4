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
	public void displayAllCarInformation() {
		System.out.println(/*Information, MaintenceCost, FuelEffeciency, VehicleStart, CarsPresentInVehileList*/);
		System.out.println(/*if vehicle not found, print error*/);
	}
	public void displayAllTruckInformation() {
		System.out.println(/*Information, MaintenceCost, FuelEffeciency, VehicleStart, TrucksPresentInVehileList*/);
		System.out.println(/*if vehicle not found, print error*/);
	}
	public void displayAllSUVInformation() {
		System.out.println(/*Information, MaintenceCost, FuelEffeciency, VehicleStart, SUVPresentInVehileList*/);
		System.out.println(/*if vehicle not found, print error*/);
	}
	public void displayAllMotorBikeInformation() {
		System.out.println(/*Information, MaintenceCost, FuelEffeciency, VehicleStart, MotorBikePresentInVehileList*/);
		System.out.println(/*if vehicle not found, print error*/);
	}
	public void displayVehicleInformation(Vehicle v) {
		System.out.println(/*Information, MaintenceCost, FuelEffeciency, VehicleStart, Vehicle?PresentInVehileList*/);
		System.out.println(/*if vehicle not found, print error*/);
	}
	public void displayAllVehicleInformation() {
		System.out.println(/*Information, MaintenceCost, FuelEffeciency, VehicleStart, VehileList*/);
		System.out.println(/*if vehicle list empty, print*/);
	}
	public ArrayList<Vehicle> getVehicleWithLowestMaintenceCost(double distance) {
		//calculate the maintenance cost of each vehicle in the list and return the lowest
		//if multiple vehicles have the same cost, randomly return
		return null;
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

    public boolean removeVehicle(Vehicle vehicle) {
		if (!vehicleList.contains(vehicle)){
			vehicleList.remove(vehicle);
			return true;
		}
		return false;
	}

    private boolean isVehicleType(Vehicle v, Class clazz) {
		if (clazz == Car.class && v instanceof Car) {
			return true;
		} else if (clazz == MotorBike.class && v instanceof MotorBike) {
			return true;
		} else if (clazz == SUV.class && v instanceof SUV) {
			return true;
		} else if (clazz == Truck.class && v instanceof Truck) {
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
    	double fuelEfficiency1 = 0.0;
		double fuelEfficiency2 = 0.0;
    	for(Vehicle vehicle: VehicleManager.getInstance().getArray()) {
    		
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
    		System.out.println(vehicle.toString()+"\nFuel Efficiency: " + fuelEfficiency1);
    		
    		if(fuelEfficiency1 > fuelEfficiency2) {
    			myVehicles.clear();
    			myVehicles.add(vehicle);
    			fuelEfficiency2 = fuelEfficiency1;
    		}
    		else if(fuelEfficiency1 == fuelEfficiency2) {
    			myVehicles.add(vehicle);
    		}
    		
    		
//    		for(Vehicle vehicle1 : myVehicles) {
//        		System.out.println(vehicle1.toString());
//    		}

    		
    	}
		return myVehicles;
    	
    }
    
    public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice){
    	distance = VehicleManager.distance;
    	fuelPrice = VehicleManager.fuelPrice;
    	ArrayList<Vehicle> myVehicles = new ArrayList<Vehicle>();
		double fuelEfficiency1 = 0.0;
		double fuelEfficiency2 = 100.0; //initialized to value larger than will ever occur
    	for(Vehicle vehicle: VehicleManager.getInstance().getArray()) {

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
    		
    		if(fuelEfficiency1 < fuelEfficiency2) {
    			myVehicles.clear();
    			myVehicles.add(vehicle);
    			fuelEfficiency2 = fuelEfficiency1;
    		}
    		else if(fuelEfficiency1 == fuelEfficiency2) {
    			myVehicles.add(vehicle);
    		}	

    	}
		return myVehicles;
    	
    }
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
		return fuelPrice;
    	//Calculate the average/mean of the fuel efficiency of SUVs in the vehicle list.
    	//Use the isVehicleType(Vehicle v, Class clazz) method.
    	//If no SUVs exist in the list return -1.0 as an error code that indicates there is no SUVs in the list to calculate the average fuel efficiency.
    }
}
