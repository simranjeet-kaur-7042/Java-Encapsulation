abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    abstract void calculateSalary();

    public int getId() {
        return employeeId;
    }

    public void setEmployeeId(int empId) {
        employeeId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String empName) {
        name = empName;
    }

    public double getSalary() {
        return baseSalary;
    }

    public void setSalary(double salary) {
        baseSalary = salary;
    }

    void displayDetails() {
        System.out.println("\nEmployee ID: " + employeeId);
        System.out.println("Employee Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
    }
}

interface Department {
    void assignDepartment(String deptName);
    void getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double fixedSalary;
    private double bonus;

    FullTimeEmployee(int id, String name, double fixedSalary, double bonus) {
        setEmployeeId(id);
        setName(name);
        this.fixedSalary = fixedSalary;
        this.bonus = bonus;
    }

    @Override
    void calculateSalary() {
        setSalary(fixedSalary + bonus);
    }

    @Override
    public void assignDepartment(String deptName) {
        department = deptName;
    }

    @Override
    public void getDepartmentDetails() {
        System.out.println("Department: " + department);
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + department);
    }
}

class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int workHours, double hourlyRate) {
        setEmployeeId(id);
        setName(name);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    void calculateSalary() {
        setSalary(workHours * hourlyRate);
    }

    @Override
    public void assignDepartment(String deptName) {
        department = deptName;
    }

    @Override
    public void getDepartmentDetails() {
        System.out.println("Department: " + department);
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + department);
    }
}

class EmployeeManagement {
    public static void main(String[] args) {
        FullTimeEmployee f = new FullTimeEmployee(101, "Aman", 5000, 500);
        f.assignDepartment("HR");
        f.calculateSalary();

        PartTimeEmployee p = new PartTimeEmployee(102, "Bob", 80, 20);
        p.assignDepartment("IT");
        p.calculateSalary();
        
        f.displayDetails();
        p.displayDetails();
    }
}
