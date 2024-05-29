package Prototype;

public class Rectangle extends Shape{
    public Rectangle(){
        this.setType("Rectangle");
        System.out.println("inside Rectangle");
    }
    @Override
    void draw() {
        System.out.println("Rectangle Draw Method");
    }
}
