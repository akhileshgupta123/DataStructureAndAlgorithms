package Factory;
/*
It allows you to create objects without specifying the exact class of object that will be created, which can make your code more flexible and easier to change.
It allows you to encapsulate the process of creating objects, making it easier to change the way objects are created in the future, without affecting the code that uses the factory.
It can make your code more reusable, as you can use the factory to create objects in a variety of contexts.
*/
public class VehicleFactory {
    public IVehicle getVehicle(String vehicleType){
        if(vehicleType.equalsIgnoreCase("car")){
            return new Car();
        }else if(vehicleType.equalsIgnoreCase("truck")){
            return new Truck();
        }else if(vehicleType.equalsIgnoreCase("bus")){
            return new Bus();
        }else{
            return null;
        }

    }
}
