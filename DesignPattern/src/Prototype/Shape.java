package Prototype;

/*
The prototype pattern allows you to create new objects by copying an existing object, rather than creating new objects using a class's constructor.
The prototype object acts as a blueprint for creating new objects.
The new objects are created by copying the prototype.
It allows you to create new objects more quickly and easily than if you were to use a class's constructor.
It allows you to create new objects that are copies of existing objects, rather than creating new objects that are completely independent.
It allows you to create new objects that have the same state as the prototype but can be modified independently.
*/

public abstract class Shape implements Cloneable{
    private String id;
    private String type;

    public Shape(){
        System.out.println("inside shape");
    }

    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }catch(CloneNotSupportedException ex){

        }
        return clone;
    }
}
