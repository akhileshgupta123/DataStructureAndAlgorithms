/*the Command interface*/
 
interface Command{
    void execute();
}


 // Concrete Command

/*the Command for turning on the light*/
 
class TurnOnLightCommand implements Command{
   private Light theLight; // Receiver object
 
   public TurnOnLightCommand(Light light){
        this.theLight=light;
       }
 
   public void execute(){
      theLight.turnOn();
   }
}
 
  // Concrete Command

/*the Command for turning off the light*/
 
class TurnOffLightCommand implements Command{
   private Light theLight; // Receiver object
 
   public TurnOffLightCommand(Light light){
        this.theLight=light;
       }
 
   public void execute(){
      theLight.turnOff();
   }
}
 
 

/*the Invoker class*/
class Switch {
	// ask command to carry out request

    private Command flipUpCommand; 
    private Command flipDownCommand;
 
    public Switch(Command flipUpCmd,Command flipDownCmd){
            this.flipUpCommand=flipUpCmd;
            this.flipDownCommand=flipDownCmd;
           }
 
    public void flipUp(){
         flipUpCommand.execute();
    }
 
    public void flipDown(){
         flipDownCommand.execute();
    }
}
 
/*Receiver class*/
 
class Light{
     public Light(){  }
		
	// Action
     public void turnOn(){
        System.out.println("The light is on");
     }
 
     public void turnOff(){
        System.out.println("The light is off");
     }
}
  


/*The test class*/
public class TestCommand{
   public static void main(String[] args){
	   //Receiver Object
       Light l=new Light();
	   //Concrete Command Object
       Command switchUp=new TurnOnLightCommand(l);
       Command switchDown=new TurnOffLightCommand(l);
 
       Switch s=new Switch(switchUp,switchDown);
	
	   // Using Invoker  ask command to carry out request

       s.flipUp();
       s.flipDown();
   }
}
