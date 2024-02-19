package edu.mu.vehicle;

import java.time.Year;

public class Truck extends Vehicle {

	//copy constructor for Truck
	public Truck(Truck truck) {
		super(truck);
		brand = truck.brand;
		make = truck.make;
		modelYear = truck.modelYear;
		price = truck.price;
		color = truck.color;
		fuelType = truck.fuelType;
		mileage = truck.mileage;
		mass = truck.mass;
		cylinders = truck.cylinders;
		gasTankCapacity = truck.gasTankCapacity;
		startType = truck.startType;
	}

	@Override
	public double calculateMaintenaceCost(double distance) {
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
