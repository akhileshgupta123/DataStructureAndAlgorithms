
/** "Abstraction" */


interface Intf {
public void stop();
public void start();
}


/** "Implementor" */

interface Switch {
public void switchOn(String electricAppliance);
public void switchOff(String electricAppliance);
}

/** "ConcreteImplementor"  */


class mySwitch implements Switch{
public void switchOn(String electricAppliance){
System.out.println("Give Electricity to the "+electricAppliance+" Appliance");
}
public void switchOff(String electricAppliance){
System.out.println("Disconnect the Electricity from the "+electricAppliance+" Appliance");
}
}

/** "Refined Abstraction" */

class ClassFanBridge implements Intf{
	private mySwitch obj;
	private String applicanceName = "Fan";
	ClassFanBridge()
	{
		obj = new mySwitch();
	}


	public void stop(){
	obj.switchOff(applicanceName);
	}

	public void start(){
	obj.switchOn(applicanceName);
	}
}

/** "Refined Abstraction" */

class ClassBulbBridge implements Intf{
	private mySwitch obj;
	private String applicanceName = "Bulb";
	ClassBulbBridge()
	{
		obj = new mySwitch();
	}


	public void stop(){
	obj.switchOff(applicanceName);
	}

	public void start(){
	obj.switchOn(applicanceName);
	}
}

// Client

	public class MyBridgePattern
	{
		public static void main(String ar[])
		{
		
		ClassFanBridge classFanbridge = new ClassFanBridge();
		classFanbridge.start();
		classFanbridge.stop();

		ClassBulbBridge classBulbbridge = new ClassBulbBridge();
		classBulbbridge.start();
		classBulbbridge.stop();
		}
	}
