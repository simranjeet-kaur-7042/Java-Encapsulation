//Create a Patient class with the following features:
// Static:A static variable hospitalName shared among all patients.A static method getTotalPatients()to count the total patients admitted.This:Use this to initialize name,age,and ailment in the constructor.Final:Use a final variable patientID to uniquely identify each patient.Instanceof:Check if an object is an instance of the Patient
// class before displaying its details.

class Patient {
        private static String hospitalName = "City Hospital";
        private static int totalPatients = 0;
        private final int patientID;
        private String name;
        private int age;
        private String ailment;

    public Patient(int patientID, String name, int age, String ailment) {
     	this.patientID = patientID;
     	this.name = name;
     	this.age = age;
     	this.ailment = ailment;
     	totalPatients++;
 	}

    public void displayPatientDetails() {
     	if (this instanceof Patient) { 
         	System.out.println("Hospital Name: " + hospitalName);
         	System.out.println("Patient ID: " + patientID);
         	System.out.println("Name: " + name);
         	System.out.println("Age: " + age);
         	System.out.println("Ailment: " + ailment);
     	}
 	}

    public static void getTotalPatients() {
     	System.out.println("Total Patients Admitted: " + totalPatients);
 	}
    }

 public class HospitalManagementSystem {
 	public static void main(String[] args) {
     	Patient p1 = new Patient(101, "Aman", 22, "Fever");
     	Patient p2 = new Patient(102, "Adarsh", 23, "Cold");

        p1.displayPatientDetails();
     	System.out.println();
        p2.displayPatientDetails();
     	Patient.getTotalPatients();
 	}
 }
