package edu.mu.vehicle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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
//	        if(file.delete()) {
//	        	System.out.println("File successfully deleted!");
//	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("File not found");
	        e.printStackTrace();
	        return false;
	    }
    	return true;
    }
    
    public boolean addVehicle(Vehicle vehicle) {
    		if (!vehicleList.contains(vehicle)){
    			vehicleList.add(vehicle);
    			return true;
    		}
		return false;
	}

    public boolean removeVehicle(Vehicle vehicle) {
    	for(Vehicle v : vehicleList) {
    		if (v.equals(vehicle)){
    			vehicleList.remove(vehicle);
    			return true;
    		}
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

    public int getNumberOfVehiclesByType(Class clazz) {
    	int count = 0;
    	for (Vehicle vehicle : vehicleList) {
        	if (isVehicleType(vehicle, clazz)) {
            		count++;
        	}
    	}
    	return count;
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
    		
    		fuelEfficiency1 = vehicle.calculateFuelEfficiency(distance, fuelPrice);
    		
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

    		fuelEfficiency1 = vehicle.calculateFuelEfficiency(distance, fuelPrice);
    		
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
        int suvCount = 0;
        double totalFuelEfficiency = 0.0;
        
        // Iterate over all vehicles in the vehicle list
        for (Vehicle vehicle : vehicleList) {
            // Check if the vehicle is an SUV
            if (vehicle instanceof SUV) {
                // Increment count of SUVs
                suvCount++;
                // Calculate fuel efficiency of the SUV and add to total
                totalFuelEfficiency += vehicle.calculateFuelEfficiency(distance, fuelPrice);
            }
        }
        
        // If no SUVs exist in the list, return -1.0 as an error code
        if (suvCount == 0) {
            return -1.0;
        }
        
        // Calculate average fuel efficiency of SUVs
        double averageFuelEfficiency = totalFuelEfficiency / suvCount;
        
        return averageFuelEfficiency;
    	}
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance){
    	Random random = new Random();
 	    Vehicle vehicleWithLowestMaintenanceCost = null;
 	    double LowestMaintenanceCost = Double.MIN_VALUE; // Initialize to minimum value
 	
 	    for (Vehicle vehicle : vehicleList) {
 	        double maintenanceCost = vehicle.calculateMaintenanceCost(distance);
 	        if (maintenanceCost < LowestMaintenanceCost) {
 	        	vehicleWithLowestMaintenanceCost = vehicle;
 	        	LowestMaintenanceCost = maintenanceCost;
 	        } else if (maintenanceCost == LowestMaintenanceCost) {
 	            if (random.nextBoolean()) {
 	                vehicleWithLowestMaintenanceCost = vehicle;
 	        		return vehicleWithLowestMaintenanceCost;
 	            }
 	          }
 	        }
 		return vehicleWithLowestMaintenanceCost;
     }
    public Vehicle getVehicleWithHighestMaintenanceCost(double distance){
    	Random random = new Random();
 	    Vehicle vehicleWithHighestMaintenanceCost = null;
 	    double HighestMaintenanceCost = Double.MIN_VALUE;
 	
 	    for (Vehicle vehicle : vehicleList) {
 	        double maintenanceCost = vehicle.calculateMaintenanceCost(distance);
// 	        System.out.println(vehicle.toString() + '\n' + "Maintenance Cost: " + maintenanceCost);
 	        if (maintenanceCost > HighestMaintenanceCost) {
 	        	vehicleWithHighestMaintenanceCost = vehicle;
 	        	HighestMaintenanceCost = maintenanceCost;
 	        } else if (maintenanceCost == HighestMaintenanceCost) {
 	            if (random.nextBoolean()) {
 	                vehicleWithHighestMaintenanceCost = vehicle;
 	        		return vehicleWithHighestMaintenanceCost;
 	            }
 	          }
 	        }
 		return vehicleWithHighestMaintenanceCost;
     }

    public void displayAllCarInformation() {
        boolean foundCar = false;

        for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Car) {
                foundCar = true;

                System.out.println(vehicle.toString());
                
                System.out.println("Maintenance Cost: " + vehicle.calculateMaintenanceCost(distance));
                
                System.out.println("Fuel Efficiency: " + vehicle.calculateFuelEfficiency(distance, fuelPrice));
            }
        }
        if (!foundCar) {
            System.out.println("No cars found.");
        }

    }
    
    public boolean saveVehicleList() {
		try {
			FileWriter file = new FileWriter(vehicleFilePath);
			BufferedWriter bw = new BufferedWriter(file);
			bw.write("Type,Model,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType");
			bw.newLine();
			for(Vehicle vehicle: VehicleManager.getInstance().getArray()) {
				if(vehicle instanceof Car) {
					String type = "Car";
					bw.write(type + "," + vehicle.getBrand() + "," + vehicle.getMake() + "," + vehicle.getModelYear() + "," + vehicle.getPrice() + "," + vehicle.getColor() + "," + vehicle.getFuelType()
					 + "," + vehicle.getMileage() + "," + vehicle.getMass() + "," + vehicle.getCylinders() + "," + vehicle.getGasTankCapacity() + "," + vehicle.getStartType());
					bw.newLine();
	            }
	            else if(vehicle instanceof MotorBike)
	            {
	            	String type = "MotorBike";
					bw.write(type + "," + vehicle.getBrand() + "," + vehicle.getMake() + "," + vehicle.getModelYear() + "," + vehicle.getPrice() + "," + vehicle.getColor() + "," + vehicle.getFuelType()
					 + "," + vehicle.getMileage() + "," + vehicle.getMass() + "," + vehicle.getCylinders() + "," + vehicle.getGasTankCapacity() + "," + vehicle.getStartType());
					bw.newLine();
	            }
	            else if(vehicle instanceof SUV)
	            {
	            	String type = "SUV";
					bw.write(type + "," + vehicle.getBrand() + "," + vehicle.getMake() + "," + vehicle.getModelYear() + "," + vehicle.getPrice() + "," + vehicle.getColor() + "," + vehicle.getFuelType()
					 + "," + vehicle.getMileage() + "," + vehicle.getMass() + "," + vehicle.getCylinders() + "," + vehicle.getGasTankCapacity() + "," + vehicle.getStartType());
					bw.newLine();
	            }
	            else if(vehicle instanceof Truck)
	            {
	            	String type = "Truck";
					bw.write(type + "," + vehicle.getBrand() + "," + vehicle.getMake() + "," + vehicle.getModelYear() + "," + vehicle.getPrice() + "," + vehicle.getColor() + "," + vehicle.getFuelType()
					 + "," + vehicle.getMileage() + "," + vehicle.getMass() + "," + vehicle.getCylinders() + "," + vehicle.getGasTankCapacity() + "," + vehicle.getStartType());
					bw.newLine();
	            }
					
			}
			bw.close();
			file.close();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		return true;
	}
}
