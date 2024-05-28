package isp.solution;
/*
 the Robot class can implement only the Workable interface, and the Human class can implement both Workable and Eatable interfaces:
By doing this, we adhere to the Interface Segregation Principle,
ensuring that classes implement only the interfaces they need, thus avoiding unnecessary dependencies and potential problems.
*/
public class Robot implements Workable{
    @Override
    public void work() {
        System.out.println("Robot working");
    }
}
