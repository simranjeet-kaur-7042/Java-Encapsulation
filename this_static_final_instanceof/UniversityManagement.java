//Create a Student class to manage student data with the following features:
// Static:A static variable universityName shared across all students.A static method displayTotalStudents() to show the number of students enrolled.
// This:Use this in the constructor to initialize name, rollNumber, and grade.
// Final:Use a final variable rollNumber for each student that cannot be changed.
// Instanceof:Check if a given object is an instance of the Student class before performing operations like displaying or updating grades.

class Student {
 	private static String universityName = "Chitkara University"; 
 	private final int rollNumber; 
 	private String name;
 	private String grade;

 	public Student(int rollNumber, String name, String grade) {
     	this.rollNumber = rollNumber;
     	this.name = name;
     	this.grade = grade;
 	}

 	public void displayStudentDetails() {
     	if (this instanceof Student) { 
         	System.out.println("University: " + universityName);
         	System.out.println("Roll Number: " + rollNumber);
         	System.out.println("Name: " + name);
         	System.out.println("Grade: " + grade);
     	}
 	}
 }

 public class UniversityManagement {
 	public static void main(String[] args) {
     	Student stu1 = new Student(101, "Aarav", "A+");
     	Student stu2 = new Student(102, "Ankush", "A");

     	stu1.displayStudentDetails();
     	stu2.displayStudentDetails();
 	}
 }

