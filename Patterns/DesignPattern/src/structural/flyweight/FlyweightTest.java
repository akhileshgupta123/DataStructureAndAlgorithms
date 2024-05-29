import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

// FlyWeight

interface FlyweightIntr {

  public String getCompany();

  public String getAddress();

  public String getCity();

  public String getState();

  public String getZip();
}

// UnsharedConcreteFlyweight
  //Store extrinsic state
class VCard {

  String name;

  String title;

  FlyweightIntr objFW;

  public VCard(String n, String t, FlyweightIntr fw) {
    name = n;
    title = t;
    objFW = fw;
  }

  public void print() {
    System.out.println(name);
    System.out.println(title);
    System.out.println(objFW.getCompany()+"-"+objFW.getAddress() + "-" + objFW.getCity() + "-"
        + objFW.getState() + "-" + objFW.getZip());
    System.out.println("----------------");
  }

}

//FlyweightFactory

class FlyweightFactory {
  private HashMap lstFlyweight;

  private static FlyweightFactory factory = new FlyweightFactory();

  private FlyweightFactory() {
    lstFlyweight = new HashMap();
  }

  public synchronized FlyweightIntr getFlyweight(String divisionName) {
    if (lstFlyweight.get(divisionName) == null) {
      FlyweightIntr fw = new Flyweight(divisionName);
      lstFlyweight.put(divisionName, fw);
      return fw;
    } else {
      return (FlyweightIntr) lstFlyweight.get(divisionName);
    }
  }

  public static FlyweightFactory getInstance() {
    return factory;
  }

  //Inner flyweight class
  //Store intrinsic state
  //ConcreteFlyweight

  private class Flyweight implements FlyweightIntr {
    private String company;

    private String address;

    private String city;

    private String state;

    private String zip;

    private void setValues(String cmp, String addr, String cty, String st,
        String zp) {

      company = cmp;
      address = addr;
      city = cty;
      state = st;
      zip = zp;

    }

    private Flyweight(String division) {
      // values are hard coded
      //for simplicity

      if (division.equals("North")) {
        setValues("Adobe", "addr1", "cty1", "st1", "10000");
      }
      if (division.equals("South")) {
        setValues("Adobe", "addr2", "cty2", "st2", "20000");
      }
      if (division.equals("East")) {
        setValues("Adobe", "addr3", "cty3", "st3", "30000");
      }
      if (division.equals("West")) {
        setValues("Adobe", "addr4", "cty4", "st4", "40000");
      }
    }

    public String getCompany() {
      return company;
    }

    public String getAddress() {
      return address;
    }

    public String getCity() {
      return city;
    }

    public String getState() {
      return state;
    }

    public String getZip() {
      return zip;
    }

  }// end of Flyweight

}// end of FlyweightFactory



// Client

public class FlyweightTest {

  public static void main(String[] args) throws Exception {
    Vector empList = initialize();
    FlyweightFactory factory = FlyweightFactory.getInstance();

    for (int i = 0; i < empList.size(); i++) {
      String s = (String) empList.elementAt(i);
      StringTokenizer st = new StringTokenizer(s, ",");
      String name = st.nextToken();
      String title = st.nextToken();
      String division = st.nextToken();

      FlyweightIntr flyweight = factory.getFlyweight(division);
      //associate the flyweight
      //with the extrinsic data object.
      VCard card = new VCard(name, title, flyweight);
      card.print();
    }
  }

  private static Vector initialize() {
    //for simplicity values are being hardcoded.

    Vector v = new Vector();
    v.add("name1,title1,North");
    v.add("name2,title2,South");
    v.add("name3,title1,North");
    v.add("name4,title3,East");
    v.add("name5,title4,East");
    v.add("name6,title2,East");
    v.add("name7,title1,West");
    v.add("name8,title3,West");
    v.add("name9,title1,West");
    v.add("name10,title6,South");
    v.add("name11,title5,North");
    v.add("name12,title1,North");

    return v;
  }
}


