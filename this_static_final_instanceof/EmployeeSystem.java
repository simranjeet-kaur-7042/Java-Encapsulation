// Design an Employee class with the following features:
// Static:A static variable companyName shared by all employees.A static method displayTotalEmployees() to show the total number of employees.
// This:Use this to initialize name, id, and designation in the constructor.
// Final:Use a final variable id for the employee ID, which cannot be modified after assignment.
// Instanceof :Check if a given object is an instance of the Employee class before printing the employee details.

class Employee{
    private static String companyName="ABC company";
    public static int totalEmployees=0;
    private String empName;
    private final int empId;
    private String designation;

    Employee(int empId,String empName,String designation){
        this.empId=empId;
        this.empName=empName;
        this.designation=designation;
        totalEmployees++;
    }

    public void displayEmployeeDetails(){
        if(this instanceof Employee){
            System.out.println("\nCompany Name : " + companyName);
         	System.out.println("Employee ID: " + empId);
         	System.out.println("Employee Name: " + empName);
         	System.out.println("Designation: " + designation);
        }
    }

    public static void displayTotalEmployees(){
        System.out.println("\nTotal Employees: " + totalEmployees);
    }
}

 public class EmployeeSystem {
 	public static void main(String[] args) {
     	Employee emp1 = new Employee(1, "Aman", "Software Engineer");
     	Employee emp2 = new Employee(2, "Adarsh", "Manager");

     	emp1.displayEmployeeDetails();
     	emp2.displayEmployeeDetails();
        Employee.displayTotalEmployees();
 	}

}