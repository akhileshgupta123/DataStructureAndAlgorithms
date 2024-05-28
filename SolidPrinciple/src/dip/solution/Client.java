package dip.solution;
/*
The Client class depends on the UserService interface rather than the concrete UserService class, adhering to the Dependency Inversion Principle.

This approach decouples the Client class from the specific implementation of user operations,

making it easier to modify or replace the underlying implementation without modifying the Client class.

It promotes code flexibility, maintainability, and testability in the long run.


 */
public class Client {
    private UserService userService;

    public Client(UserService userService) {
        this.userService = userService;
    }

    void registerUser(User user) {
        userService.addUser(user);
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        Client client = new Client(userService);

        // Usage
        User newUser = new User("John Doe");
        client.registerUser(newUser);
    }
}
