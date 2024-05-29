package Prototype;

public class Square extends Shape{

    public Square(){
        this.setType("Square");
        System.out.println("inside Square");
    }
    @Override
    void draw() {
        System.out.println("Square Draw Method");
    }
}
