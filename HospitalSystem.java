//Description: Design a system to manage patients in a hospital:
// Create an abstract class Patient with fields like patientId, name, and age.
// Add an abstract method calculateBill() and a concrete method getPatientDetails().
// Extend it into subclasses InPatient and OutPatient, implementing calculateBill() with different billing logic.
// Implement an interface MedicalRecord with methods addRecord() and viewRecords().
// Use encapsulation to protect sensitive patient data like diagnosis and medical history.
// Use polymorphism to handle different patient types and display their billing details dynamically.


interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private String[] medicalHistory = new String[10];
    private int recordCount = 0;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        if(recordCount < medicalHistory.length) {
            medicalHistory[recordCount] = record;
            recordCount++;
        } else {
            System.out.println("Cannot add more records for " + getName());
        }
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for(int i = 0; i < recordCount; i++) {
            System.out.println("- " + medicalHistory[i]);
        }
    }

    @Override
    public String toString() {
        return "InPatient: " + getPatientDetails() + ", Days Admitted: " + daysAdmitted + ", Total Bill: " + calculateBill();
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String[] medicalHistory = new String[10]; 
    private int recordCount = 0;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        if(recordCount < medicalHistory.length) {
            medicalHistory[recordCount] = record;
            recordCount++;
        } else {
            System.out.println("Cannot add more records for " + getName());
        }
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for(int i = 0; i < recordCount; i++) {
            System.out.println("- " + medicalHistory[i]);
        }
    }

    @Override
    public String toString() {
        return "OutPatient: " + getPatientDetails() + ", Consultation Fee: " + consultationFee;
    }
}

public class HospitalSystem{
    public static void main(String[] args) {
        Patient patient1 = new InPatient("IP001", "Akash", 30, 5, 2000);
        Patient patient2 = new OutPatient("OP001", "Divya", 25, 500);
        ((MedicalRecord) patient1).addRecord("Diagnosed with pneumonia");
        ((MedicalRecord) patient1).addRecord("Prescribed antibiotics");
        ((MedicalRecord) patient2).addRecord("Routine checkup");

        System.out.println(patient1);
        ((MedicalRecord) patient1).viewRecords();

        System.out.println("\n" + patient2);
        ((MedicalRecord) patient2).viewRecords();

        System.out.println("\nTotal Bill for " + patient1.getName() + ": " + patient1.calculateBill());
        System.out.println("Total Bill for " + patient2.getName() + ": " + patient2.calculateBill());
    }
}
