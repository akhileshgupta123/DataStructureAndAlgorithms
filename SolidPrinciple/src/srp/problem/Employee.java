package srp.problem;

public class Employee {

    private String name;
    private String position;
    private double salary;

    // Constructor, getters, and setters
    Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void generateReport() {
        // Logic to generate employee report
        System.out.println("Employee Report:");
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Salary: $" + salary);
        // Additional report generation logic
    }
}
