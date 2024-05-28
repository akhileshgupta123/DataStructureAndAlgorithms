package srp.solution;

/*Managing Employee Details (name, position, salary): Storing and managing employee information.*/

/* the Single Responsibility Principle, making the codebase more modular, maintainable, and easier to understand.*/

public class Employee {
    private String name;
    private String position;
    private double salary;

    // Constructor, getters, and setters

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
}
