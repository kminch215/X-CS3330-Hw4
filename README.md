# X-CS3330-Hw4
Names: Kendra Minch, Samantha Whitaker, Sarah Greenwood, and Lane Parker

The assignment is to create a Java program for a vehicle showroom management system. There are six classes that are implemented: `Vehicle`, `Truck`, `Car`, `SUV`, `MotorBike`, and `VehicleManager`. The `Vehicle` class is a abstract base class for the subclasses `Truck`, `Car`, `SUV`, and `MotorBike`. Additionally, there are three Enums that are implemented: `VehicleColor`, `FuelType`, and `StartMechanism`.

**Vehicle Class**: 
   - A class with protected fields for car attributes: brand(String), make(String), modelYear(long), price(double), color(VehicleColor), fuelType(FuelType), mileage(double), mass(double), cylinders(int), gasTankCapacity(double), and startType(StartMechanism).
   - Has parameterized constructor, copy constructor, getter/setter methods, and a toString() method to display student information.
   - Has the method prototype for the abstract methods: calculateMaintenanceCost(double distance), calculateFuelEfficiency(double distance, double fuelPrice), void startEngine()

  **VehicleManager Class**: 
   - A class uses the Singleton design pattern to ensure the the `VehicleManager` class has one instance and every other class has one global access point to the instance.
   - The `VehicleManager` Class has attributes String vehicleFilePath, double distance, and double fuelPrice
   - read the initial inventory from a CSV file (vehicleList.csv) during initialization, update existing items, add new items, remove items, and save the updated inventory back to the CSV file.
   - Additionally, we have our initializeStock, displayAllCarInformation, displayAllTruckInformation, displayAllSUVInformation, displayAllMotorBikeInformation, displayVehicleInformation, displayAllVehicleInformation, removeVehicle, addVehicle, saveVehicleList, isVehicleType, getNumberOfVehichlesByType, getVehicleWithHighestMaintenanceCost, getVehicleWithLowestMaintenanceCost, getVehicleWithHighestFuelEfficiency, getVehicleWithLowestFuelEfficiency, and getAverageFuelEfficiencyOfSUVs methods implemented here.

### How to run:
1. First make sure to have a way to compile and run Java files. It also might help to have an IDE like Eclipse to run the code.
2. Implement a syntactically and logically correct program to put in the main() method in the Main Class. This method is going to be accessing the `VehicleManager` class and calling the different methods to manage the vehicle showroom management system.
   - To access the methods, use the syntax structure `VehicleManager.getInstance()` followed by the method name you want to call.
   - To access the instance, use the syntax structure `VehicleManager.getInstance().getArray()`
4. After saving the Main Class file, then run the code using your desired method. For this assignment we used the Run feature in the Eclipse IDE
