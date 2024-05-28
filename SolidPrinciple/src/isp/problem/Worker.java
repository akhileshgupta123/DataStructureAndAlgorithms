package isp.problem;

/*
The Interface Segregation Principle (ISP) is one of the SOLID principles of object-oriented design.
It states that a class should not be forced to implement interfaces it does not use.
In other words, clients should not be forced to depend on interfaces they do not use.
Both Robot and Human classes are forced to implement both methods, even though robots don't eat.
This violates the Interface Segregation Principle because the Robot class is forced to implement a method (eat()) that it doesn't need.
*/
public interface Worker {
    void work();
    void eat();
}
