import java.util.Vector;

/** "Component" */

interface Employee {
		public String getName();
		public void setName(String name);
		public double getSalary();
		public void setSalary(double salary);
		public void display();
}

/** "Composite" */

class EmployeeComposite implements  Employee{
	
		private String name;
		private double salary;
		private Vector<Employee> subordinates;

		// constructor
		public EmployeeComposite(String name, double sal) {
		setName(name);
		setSalary(sal);
		subordinates = new Vector<Employee>();
		}

		public String getName() {
		return name;
		}

		public void setName(String name) {
		this.name = name;
		}

		public double getSalary() {
		return salary;
		}

		public void setSalary(double salary) {
		this.salary = salary;
		}

		public void add(Employee e) {
		subordinates.addElement(e);
		}

		public void remove(Employee e) {
		subordinates.remove(e);
		}

		public void display() {
		for(Employee emp:subordinates) {
		emp.display();
		}
		System.out.println("In EmployeeComposite class Designation..." + getName()+"    Salary...."+getSalary());
	  }

}// End of class

/** "Leaf" */

class EmployeeLeaf  implements  Employee
{
		private String name;
		private double salary;

		// constructor
		public EmployeeLeaf(String name, double sal) {
		setName(name);
		setSalary(sal);
		
		}

		public String getName() {
		return name;
		}

		public void setName(String name) {
		this.name = name;
		}

		public double getSalary() {
		return salary;
		}

		public void setSalary(double salary) {
		this.salary = salary;
		}

		public void display() {
		System.out.println("In EmployeeLeaf class Designation..." + getName()+"    Salary...."+getSalary());
		  }

}

//Next we, fill up the tree. You can make a class to access the class Employee and try filling up the tree like this:


/**
* This will add employess to the tree. The boss, is PM
* and has subordinates.
*/

/** Client */


public class CompositePattern
{
	private static EmployeeComposite CFO;

	public static void main(String args[])
	{
		CompositePattern obj = new CompositePattern();
	
		obj.addEmployeesToTree();

		CFO.display();
	}

	private void addEmployeesToTree() {

			CFO = new EmployeeComposite("CFO", 30000);

			EmployeeComposite headFinance1 = new EmployeeComposite("Head Finance. North Zone", 20000);
			EmployeeComposite headFinance2 = new EmployeeComposite("Head Finance. West Zone", 22000);

			EmployeeLeaf accountant1 = new EmployeeLeaf("Accountant1", 10000);
			EmployeeLeaf accountant2 = new EmployeeLeaf("Accountant2", 9000);

			EmployeeLeaf accountant3 = new EmployeeLeaf("Accountant3", 11000);
			EmployeeLeaf accountant4 = new EmployeeLeaf("Accountant4", 12000);

		
			headFinance1.add(accountant1);
			headFinance1.add(accountant4);

			headFinance2.add(accountant2);
			headFinance2.add(accountant3);

			CFO.add(headFinance1);
			CFO.add(headFinance2);


			//headFinance1.display();
			//accountant4.display();			
			
	}
}
  	

