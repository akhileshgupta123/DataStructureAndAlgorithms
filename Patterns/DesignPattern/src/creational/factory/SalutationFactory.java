//	Product
//This is a simple abstract class Person having methods for name and gender.
abstract class Person {
	// name string
	public String name;
	// gender : M or F
	public String gender;

	public abstract String  getName();

	public abstract String getGender();

}// End of class

// We will have two sub-classes, Male and Female which will print the welcome message on the screen.

//Concrete Product
class Male extends Person {
		public Male(String fullName) {
	System.out.println("Hello Mr. "+fullName);
	}

	public String getName() {
	return name;
	}

	public String getGender() {
	return gender;
	}
}// End of class

//Concrete Product
class Female extends Person {
		public Female(String fullNname) {
	System.out.println("Hello Ms. "+fullNname);
	}

	public String getName() {
	return name;
	}

	public String getGender() {
	return gender;
	}

}// End of class

//create a client, or a SalutationFactory which will return the welcome message depending on the data provided.
//Creator
public class SalutationFactory {
		public static void main(String args[]) {
	SalutationFactory factory = new SalutationFactory();
	factory.getPerson(args[0], args[1]);
	}

public Person getPerson(String name, String gender) {
	if (gender.equals("M"))
	return new Male(name);
	else if(gender.equals("F"))
	return new Female(name);
	else
	return null;
	}
}// End of class