package Prototype;

public class Circle extends Shape{

    public Circle(){
        this.setType("Circle");
        System.out.println("inside circle");
    }
    @Override
    void draw() {
        System.out.println("Circle Draw Method");
    }
}
