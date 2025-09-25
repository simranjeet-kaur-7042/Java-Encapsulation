//Description: Develop a ride-hailing application:
// Define an abstract class Vehicle with fields like vehicleId, driverName, and ratePerKm.
// Add abstract methods calculateFare(double distance) and a concrete method getVehicleDetails().
// Create subclasses Car, Bike, and Auto, overriding calculateFare() based on type-specific rates.
// Use an interface GPS with methods getCurrentLocation() and updateLocation().
// Secure driver and vehicle details using encapsulation.
// Demonstrate polymorphism by creating a method to calculate fares for different vehicle types dynamically.


interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}
abstract class Vehicles {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicles(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }
    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }
    protected String getCurrentLocationField() { return currentLocation; }

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate/km: " + ratePerKm;
    }

    public abstract double calculateFare(double distance);
}

class Cars extends Vehicles implements GPS {
    public Cars(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance; 
    }

    @Override
    public String getCurrentLocation() {
        return getCurrentLocationField();
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Car " + getVehicleId() + " moved from " + getCurrentLocationField() + " to " + newLocation);
    }

    @Override
    public String toString() {
        return "Car: " + getVehicleDetails();
    }
}

class Bikes extends Vehicles implements GPS {
    public Bikes(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9;
    }

    @Override
    public String getCurrentLocation() {
        return getCurrentLocationField();
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Bike " + getVehicleId() + " moved from " + getCurrentLocationField() + " to " + newLocation);
    }

    @Override
    public String toString() {
        return "Bike: " + getVehicleDetails();
    }
}

class Auto extends Vehicles implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 1.1;
    }

    @Override
    public String getCurrentLocation() {
        return getCurrentLocationField();
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Auto " + getVehicleId() + " moved from " + getCurrentLocationField() + " to " + newLocation);
    }

    @Override
    public String toString() {
        return "Auto: " + getVehicleDetails();
    }
}

public class RideHailing{
    public static void main(String[] args) {
        Vehicles vehicle1 = new Cars("C001", "Alice", 15, "Downtown");
        Vehicles vehicle2 = new Bikes("B001", "Bob", 10, "Uptown");
        Vehicles vehicle3 = new Auto("A001", "Charlie", 12, "City Center");

        double distance = 10;
        System.out.println(vehicle1);
        System.out.println("Fare for " + distance + " km: " + vehicle1.calculateFare(distance));
        ((GPS) vehicle1).updateLocation("Airport");

        System.out.println("\n" + vehicle2);
        System.out.println("Fare for " + distance + " km: " + vehicle2.calculateFare(distance));
        ((GPS) vehicle2).updateLocation("Mall");

        System.out.println("\n" + vehicle3);
        System.out.println("Fare for " + distance + " km: " + vehicle3.calculateFare(distance));
        ((GPS) vehicle3).updateLocation("Station");
    }
}
