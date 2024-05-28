package lsp.solution;
/*
Each class maintains its own logic for calculating area based on its specific properties
        (width and height for Rectangle, and side for Square).
Now, when we use objects of Rectangle or Square through the Shape interface,
        we get correct behavior without violating the Liskov Substitution Principle.
By using interfaces and designing classes based on behavior, we ensure that
        substituting subclasses for their superclasses does not lead to unexpected behavior, thus adhering to the Liskov Substitution Principle.


 */
public class Main {

    public static void main(String[] args) {
        Shape square = new Square(5);
        int area = square.calculateArea();
        System.out.println("Area: " + area); // Output: Area: 25

        Shape rectangle = new Rectangle(5, 10);
        area = rectangle.calculateArea();
        System.out.println("Area: " + area); // Output: Area: 50
    }
}
