package ocp.problem;

/*
* The Open-Closed Principle (OCP) is one of the SOLID principles of object-oriented design,
* which states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
* In simpler terms, this means that you should be able to extend the behavior of a class without modifying its source code.
* */

/*
In this example, the AreaCalculator class directly checks the type of the shape to calculate its area.
If we want to add a new shape such as a Triangle, we would need to modify the AreaCalculator class, violating the Open-Closed Principle.
* */
public class AreaCalculator {
    public double calculateArea(Shape shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.getRadius() * circle.getRadius();
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.getWidth() * rectangle.getHeight();
        }
        return 0.0;
    }
}
