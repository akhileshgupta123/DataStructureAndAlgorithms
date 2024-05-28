package lsp.problem;
/*
The Liskov Substitution Principle (LSP) is a fundamental principle in object-oriented design,
stating that objects of a superclass should be replaceable with objects of its subclasses
without affecting the correctness of the program. Violating LSP can lead to unexpected behavior and incorrect program logic.

According to geometry, a square is a special type of rectangle where all sides are equal. However,
if we model a square as a subclass of rectangle and override the setters for width and
height in a way that contradicts the behavior of rectangles, it can lead to issues when using these classes interchangeably.

the behavior of setting width and height in the Square class violates the expected behavior of a square,
where setting one side should automatically set the other side to the same value.
*/
public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Square();
        rectangle.setWidth(5);
        rectangle.setHeight(10);

        int area = rectangle.calculateArea();
        System.out.println("Area: " + area); // Output: Area: 100 (Incorrect for a square)
    }
}
