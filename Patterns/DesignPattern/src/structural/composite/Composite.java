import java.util.*;

/** "Component" */

interface Place {
void print();
}

/** "Composite" */

class State implements Place {

List<Place> placeList=new ArrayList<Place>();

public void add(Place place) {
placeList.add(place);
}

public void remove(Place place) {
placeList.remove(place);
}

public void print() {
for(Place place:placeList) {
place.print();
    }
  }
}

/** "Leaf" */

class City implements Place {

private String name;

public City(String name) {
this.name=name;
}

public void setName(String name) {
this.name=name;
}

public void print() {
System.out.println("printing..." + name);
  }
}

/** Client */

public class Composite {

public static void main(String[] args) {

State s1=new State();
State s2=new State();
State s3=new State();

City c1=new City("City1");
City c2=new City("City2");
City c3=new City("City3");

s1.add(c1);
s2.add(c2);
s3.add(s1);
s3.add(s2);
s3.add(c3);
s3.print();
  }

}