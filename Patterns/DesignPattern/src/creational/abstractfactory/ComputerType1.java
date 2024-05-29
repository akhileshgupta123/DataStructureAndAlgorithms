//abstract factory

abstract class Computer {

public abstract Parts getRAM();

public abstract Parts getProcessor();

public abstract Parts getMonitor();
}// End of class


// abstract product
abstract class Parts {
  	/**
* specification of Part of Computer, String
*/
public String specification;

/**
* Returns the name of the part of Computer
*
* @return specification of Part of Computer, String
*/
public abstract String getSpecification();
}// End of class


//Concrete Factory

class PC extends Computer {
  	/**
* Method over-ridden from Computer, returns the Parts ideal for
* PC
* @return Parts
*/
public Parts getRAM() {
return new PCParts("512 MB");
}

public Parts getProcessor() {
return new PCParts("Celeron");
}

public Parts getMonitor() {
return new PCParts("15 inches");
}
}// End of class


//Concrete Factory
 class Workstation extends Computer {
  	/**
* Method over-ridden from Computer, returns the Parts ideal for
* Workstation
* @return Parts
*/
public Parts getRAM() {
return new WorkStationParts("1 GB");
}

public Parts getProcessor() {
return new WorkStationParts("Intel P 3");
}


public Parts getMonitor() {
return new WorkStationParts("19 inches");
}
}// End of class


//Concrete Factory
 class Server extends Computer{
  	/**
* Method over-ridden from Computer, returns the Parts ideal for
* Server
* @return Parts
*/
public Parts getRAM() {
return new ServerParts("4 GB");
}


public Parts getProcessor() {
return new ServerParts("Intel P 4");
}


public Parts getMonitor() {
return new ServerParts("17 inches");
}
}// End of class


//Concrete Product
class PCParts extends Parts
{
	public PCParts(String specification) {
	this.specification = specification;
	}

	public String getSpecification() {
		return specification;
	}
}

//Concrete Product
class ServerParts extends Parts
{

	public ServerParts(String specification) {
	this.specification = specification;
	}

	public String getSpecification() {
		return specification;
	}
}

//Concrete Product
class WorkStationParts extends Parts
{

	public WorkStationParts(String specification) {
	this.specification = specification;
	}

	public String getSpecification() {
		return specification;
	}
}

//Client

public class ComputerType1 {
  	private Computer comp;

public static void main(String[] args) {
  	  	ComputerType1 type = new ComputerType1();


Computer computer = type.getComputer(args[0]);

System.out.println("Monitor: "+computer.getMonitor().getSpecification());
System.out.println("RAM: "+computer.getRAM().getSpecification());
System.out.println("Processor: "+computer.getProcessor().getSpecification());
  	}  	 
  	  	

/**
* Returns a computer for a type
*
* @param computerType String, PC / Workstation / Server
* @return Computer
*/
  	public Computer getComputer(String computerType) {
		if (computerType.equals("PC"))
		comp = new PC();
		else if(computerType.equals("Workstation"))
		comp = new Workstation();
		else if(computerType.equals("Server"))
		comp = new Server();

		return comp;
  	} 	 
}// End of class