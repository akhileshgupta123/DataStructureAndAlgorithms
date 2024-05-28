package ocp.solution;

/*
The AreaCalculator class can now calculate the area of any shape that implements
the Shape interface without needing modifications when new shapes are added.
This refactoring promotes code extensibility, maintainability, and avoids the need to modify existing code when
introducing new shapes, thus following the Open-Closed Principle.

*/

public class AreaCalculator {

    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}
