package dip.problem;
/*
* The Dependency Inversion Principle (DIP) is a principle of object-oriented design that suggests high-level modules
* should not depend on low-level modules, but rather both should depend on abstractions.
* This principle helps in writing more maintainable and flexible code by reducing the coupling between modules.
*
*
* In the above code, the Client class directly depends on the UserService class,
* violating the Dependency Inversion Principle. This direct dependency creates tight coupling between the Client
* and UserService classes, making it difficult to replace or modify the UserService class without affecting the Client class.
*
* */
public class Client {
    private UserService userService = new UserService();

    void registerUser(User user) {
        userService.addUser(user);
    }
}
