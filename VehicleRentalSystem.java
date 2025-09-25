// Design a system to manage vehicle rentals:
// Define an abstract class Vehicle with fields like vehicleNumber, type, and rentalRate.
// Add an abstract method calculateRentalCost(int days).
// Create subclasses Car, Bike, and Truck with specific implementations of calculateRentalCost().
// Use an interface Insurable with methods calculateInsurance() and getInsuranceDetails().
// Apply encapsulation to restrict access to sensitive details like insurance policy numbers.
// Demonstrate polymorphism by iterating over a list of vehicles and calculating rental and insurance costs for each.

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }
    protected String getInsurancePolicyNumber() { return insurancePolicyNumber; }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    private int seatingCapacity;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber, int seatingCapacity) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + getInsurancePolicyNumber();
    }

    @Override
    public String toString() {
        return "Vehicle Type: Car, Number: " + getVehicleNumber() + ", Seating Capacity: " + seatingCapacity;
    }
}

class Bike extends Vehicle implements Insurable {
    private boolean hasGear;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber, boolean hasGear) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
        this.hasGear = hasGear;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) - 0.05 * (getRentalRate() * days);
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + getInsurancePolicyNumber();
    }

    @Override
    public String toString() {
        return "Vehicle Type: Bike, Number: " + getVehicleNumber() + ", Has Gear: " + hasGear;
    }
}

class Truck extends Vehicle implements Insurable {
    private double loadCapacity;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber, double loadCapacity) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 500;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.2;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + getInsurancePolicyNumber();
    }

    @Override
    public String toString() {
        return "Vehicle Type: Truck, Number: " + getVehicleNumber() + ", Load Capacity: " + loadCapacity + " kg";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("C123", 2000, "CAR-INS-001", 5),
            new Bike("B456", 500, "BIKE-INS-002", true),
            new Truck("T789", 5000, "TRUCK-INS-003", 10000)
        };

        int rentalDays = 5;

        for (int i = 0; i < vehicles.length; i++) {
            Vehicle v = vehicles[i];
            Insurable ins = (Insurable) v;

            System.out.println(v); 
            System.out.println("Rental Cost: " + v.calculateRentalCost(rentalDays));
            System.out.println("Insurance Cost: " + ins.calculateInsurance());
            System.out.println(ins.getInsuranceDetails());
            System.out.println("----------------------");
        }
    }
}
