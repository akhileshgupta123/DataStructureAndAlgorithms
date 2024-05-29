class PlantCell implements Cloneable {
  	public Object split() {
  	  	try {
  	  	  	return super.clone();
}catch(Exception e) {
System.out.println("Exception occured: "+e.getMessage());
return null;
}
  	  	}

	public String toString() { return "Cloneing of Object"; }
}// End of class


/**
* Shows how to use the clone.
*/
public class CellDivision {
  	public static void main(String[] args) {
PlantCell cell = new PlantCell();

// create a clone
PlantCell newPlantCell = (PlantCell)cell.split();

System.out.println(newPlantCell);

}
}// End of class