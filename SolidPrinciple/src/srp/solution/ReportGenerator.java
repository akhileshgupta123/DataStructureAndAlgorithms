package srp.solution;

/*To adhere to the Single Responsibility Principle, we can separate the responsibilities into distinct classes.*/
/*Generating Reports (generateReport method): Generating a report containing employee details.*/

public class ReportGenerator {

    public void generateEmployeeReport(Employee employee){
        // Logic to generate employee report
        System.out.println("Employee Report:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Salary: $" + employee.getSalary());
        // Additional report generation logic
    }
}
