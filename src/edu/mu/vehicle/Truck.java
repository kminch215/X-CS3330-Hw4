package edu.mu.vehicle;

import java.time.Year;

public class Truck extends Vehicle {

	//parameterized constructor
	public Truck(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
	}

	//copy constructor
	public Truck(Vehicle vehicle) {
		super(vehicle);
	}

	@Override
	public double calculateMaintenanceCost(double distance) {
		double maintenanceCost = distance * this.mass * (Year.now().getValue() -this.modelYear) * this.cylinders * 0.002;
		
		return maintenanceCost;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = this.cylinders * this.gasTankCapacity * fuelPrice / distance * 0.1;
		
		return fuelEfficiency;
	}

	@Override
	public void startEngine() {
		this.startType = StartMechanism.KEYSTART;
	}
	

}
