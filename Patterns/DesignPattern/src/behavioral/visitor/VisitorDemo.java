// Visitor

interface Visitor {
    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    void visitCar(Car car);
}

// Concrete Visitor

class PrintVisitor implements Visitor {
 
    public void visit(Wheel wheel) {      
        System.out.println("Visiting "+ wheel.getName()
                            + " wheel");
    }
    public void visit(Engine engine) {
        System.out.println("Visiting engine");
    }
    public void visit(Body body) {
        System.out.println("Visiting body");
    }
 
    public void visitCar(Car car) {
        System.out.println("\nVisiting car");
        for(CarElement element : car.getElements()) {
            element.accept(this);
        }
        System.out.println("Visited car");
    }
}
 
// Concrete Visitor

class DoVisitor implements Visitor {
    public void visit(Wheel wheel) {
        System.out.println("Kicking my "+ wheel.getName());
    }
    public void visit(Engine engine) {
        System.out.println("Starting my engine");
    }
    public void visit(Body body) {
        System.out.println("Moving my body");
    }
    public void visitCar(Car car) {
        System.out.println("\nStarting my car");
        for(CarElement carElement : car.getElements()) {
            carElement.accept(this);
        }
        System.out.println("Started car");
    }
 
}


// Element

interface CarElement{
    public void accept(Visitor visitor);
}

// Concrete Element

class Wheel implements CarElement{
    private String name;
    Wheel(String name) {
        this.name = name;
    }
    String getName() {
        return this.name;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
 
// Concrete Element

class Engine implements CarElement{
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
 
// Concrete Element

class Body implements CarElement{
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
 

// Object Structure

class Car  {
    CarElement[] elements;
    public CarElement [] getElements(){
        return elements.clone();
    }
    public Car() {
        this.elements = new CarElement[]
          { new Wheel("front left"), new Wheel("front right"),
            new Wheel("back left") , new Wheel("back right"),
            new Body(), new Engine()};
    }
}
 

 
public class VisitorDemo {
    static public void main(String[] args){
        Car car = new Car();
        Visitor printVisitor = new PrintVisitor();
        Visitor doVisitor = new DoVisitor();
        printVisitor.visitCar(car);
        doVisitor.visitCar(car);
    }
}
