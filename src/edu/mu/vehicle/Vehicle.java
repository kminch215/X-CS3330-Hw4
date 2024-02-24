package edu.mu.vehicle;

import java.util.Objects;

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
		public abstract double calculateMaintenanceCost(double distance);
		public abstract double calculateFuelEfficiency(double distance, double fuelPrice);
		public abstract void startEngine();

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vehicle other = (Vehicle) obj;
			return Objects.equals(brand, other.brand) && color == other.color && cylinders == other.cylinders
					&& fuelType == other.fuelType
					&& Double.doubleToLongBits(gasTankCapacity) == Double.doubleToLongBits(other.gasTankCapacity)
					&& Objects.equals(make, other.make)
					&& Double.doubleToLongBits(mass) == Double.doubleToLongBits(other.mass)
					&& Double.doubleToLongBits(mileage) == Double.doubleToLongBits(other.mileage)
					&& modelYear == other.modelYear
					&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
					&& startType == other.startType;
		}

		
		//toString() method
		@Override
		public String toString() {
			return "Vehicle [brand=" + brand + ", make=" + make + ", modelYear=" + modelYear + ", price=" + price
					+ ", color=" + color + ", fuelType=" + fuelType + ", mileage=" + mileage + ", mass=" + mass
					+ ", cylinders=" + cylinders + ", gasTankCapacity=" + gasTankCapacity + ", startType=" + startType
					+ "]";
		}
		
		//parameterized constructor
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
		
		//copy constructor for Vehicle
		public Vehicle(Vehicle vehicle) {
			this.brand = vehicle.brand;
			this.make = vehicle.make;
			this.modelYear = vehicle.modelYear;
			this.price = vehicle.price;
			this.color = vehicle.color;
			this.fuelType = vehicle.fuelType;
			this.mileage = vehicle.mileage;
			this.mass = vehicle.mass;
			this.cylinders = vehicle.cylinders;
			this.gasTankCapacity = vehicle.gasTankCapacity;
			this.startType = vehicle.startType;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getMake() {
			return make;
		}
		public void setMake(String make) {
			this.make = make;
		}
		public long getModelYear() {
			return modelYear;
		}
		public void setModelYear(long modelYear) {
			this.modelYear = modelYear;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public VehicleColor getColor() {
			return color;
		}
		public void setColor(VehicleColor color) {
			this.color = color;
		}
		public FuelType getFuelType() {
			return fuelType;
		}
		public void setFuelType(FuelType fuelType) {
			this.fuelType = fuelType;
		}
		public double getMileage() {
			return mileage;
		}
		public void setMileage(double mileage) {
			this.mileage = mileage;
		}
		public double getMass() {
			return mass;
		}
		public void setMass(double mass) {
			this.mass = mass;
		}
		public int getCylinders() {
			return cylinders;
		}
		public void setCylinders(int cylinders) {
			this.cylinders = cylinders;
		}
		public double getGasTankCapacity() {
			return gasTankCapacity;
		}
		public void setGasTankCapacity(double gasTankCapacity) {
			this.gasTankCapacity = gasTankCapacity;
		}
		public StartMechanism getStartType() {
			return startType;
		}
		public void setStartType(StartMechanism startType) {
			this.startType = startType;
		}
		
		
		
}
