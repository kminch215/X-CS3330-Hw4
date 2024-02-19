package edu.mu.vehicle;

public abstract class Vehicle {

		protected String brand;
		protected String make;
		protected long modelYear;
		protected double price;
		protected VehicleColor color;
		protected FuelType fuelType;
		protected double mileage;
		protected double mass;
		protected int cylinders;
		protected double gasTankCapacity;
		protected StartMechanism startType;
		
		//abstract methods
		public abstract double calculateMaintenaceCost(double distance);
		public abstract double calculateFuelEfficiency(double distance, double fuelPrice);
		public abstract void startEngine();
		
		//toString() method
		@Override
		public String toString() {
			return "Vehicle [brand=" + brand + ", make=" + make + ", modelYear=" + modelYear + ", price=" + price
					+ ", color=" + color + ", fuelType=" + fuelType + ", mileage=" + mileage + ", mass=" + mass
					+ ", cylinders=" + cylinders + ", gasTankCapacity=" + gasTankCapacity + ", startType=" + startType
					+ "]";
		}
		
		//Vehicle constructor
		public Vehicle(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
				double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
			this.brand = brand;
			this.make = make;
			this.modelYear = modelYear;
			this.price = price;
			this.color = color;
			this.fuelType = fuelType;
			this.mileage = mileage;
			this.mass = mass;
			this.cylinders = cylinders;
			this.gasTankCapacity = gasTankCapacity;
			this.startType = startType;
		}
		
}
