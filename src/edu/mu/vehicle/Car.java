package edu.mu.vehicle;

import java.time.Year;

public class Car extends Vehicle {

	//parameterized constructor
	public Car(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
	}

	//copy constructor
	public Car(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public double calculateMaintenaceCost(double distance) {
		double maintenanceCost = distance * mass * (Year.now().getValue() - modelYear) * cylinders * 0.0005;
		
		return maintenanceCost;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = cylinders * gasTankCapacity * fuelPrice / distance * 0.003;
		
		return fuelEfficiency;
	}

	@Override
	public void startEngine() {
		startType = StartMechanism.PUSHSTART;
	}

	
	
}
