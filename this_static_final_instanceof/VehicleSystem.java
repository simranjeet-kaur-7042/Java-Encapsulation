//Create a Vehicle class with the following features:
// Static:A static variable registrationFee common for all vehicles.A static method updateRegistrationFee() to modify the fee.
// This:Use this to initialize ownerName, vehicleType, and registrationNumber in the constructor.
// Final:Use a final variable registrationNumber to uniquely identify each vehicle.
// Instanceof:Check if an object belongs to the Vehicle class before displaying its registration details.

class Vehicle {
 	private static double registrationFee = 500; 
 	private final String registrationNumber; 
 	private String ownerName;
 	private String vehicleType;

 	public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
     	this.registrationNumber = registrationNumber;
     	this.ownerName = ownerName;
     	this.vehicleType = vehicleType;
 	}




 	public void displayVehicleDetails() {
     	if (this instanceof Vehicle) { 
         	System.out.println("Registration Number: " + registrationNumber);
         	System.out.println("Owner Name: " + ownerName);
         	System.out.println("Vehicle Type: " + vehicleType);
         	System.out.println("Registration Fee: Rs." + registrationFee);
     	}
 	}
 }
 public class VehicleSystem {
 	public static void main(String[] args) {
     	Vehicle vehicle1 = new Vehicle("ABC123", "Anuj", "Car");
     	Vehicle vehicle2 = new Vehicle("MNO789", "Rajesh", "Motorcycle");

         vehicle1.displayVehicleDetails();
         vehicle2.displayVehicleDetails();
 	}
 }

