package Prototype;
import java.util.*;
public class PrototypeClient {
    private Map<String,Shape> prototypeMap;
    public PrototypeClient(){
        prototypeMap = new HashMap<String,Shape>();
    }
    public static void main(String[] args){
        PrototypeClient obj = new PrototypeClient();
        obj.populateMasterData();

        Shape clonedShape1 =  obj.findCloneObject("1");
        System.out.println("Shape : " + clonedShape1.getType());

        Shape clonedShape2 =  obj.findCloneObject("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = obj.findCloneObject("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }

    private void populateMasterData(){

        Circle circle = new Circle();
        circle.setId("1");
        prototypeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        prototypeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        prototypeMap.put(rectangle.getId(), rectangle);
    }

    public Shape findCloneObject(String shapeId){
        Shape item = prototypeMap.get(shapeId);
        return (Shape)item.clone();
    }
}
