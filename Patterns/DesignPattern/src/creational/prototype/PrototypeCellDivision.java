//Prototype

interface Xyz { Xyz clone(); }

//Concrete Prototype

class PlantCell implements Xyz {
  	public Object split() {
  	  	try {
  	  	  	return this.clone();
}catch(Exception e) {
System.out.println("Exception occured: "+e.getMessage());
return null;
}
  	  	}

   public Xyz    clone()    { return new PlantCell(); }

   public String toString() { return "Cloneing of Object"; }
}// End of class


/**
* Shows how to use the clone.
*/

//Clients

public class PrototypeCellDivision{
  	public static void main(String[] args) {
PlantCell cell = new PlantCell();

// create a clone
PlantCell newPlantCell = (PlantCell)cell.split();

System.out.println(newPlantCell);

}
}// End of class