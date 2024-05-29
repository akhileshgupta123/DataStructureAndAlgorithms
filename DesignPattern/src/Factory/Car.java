package Factory;

public class Car implements IVehicle{
    @Override
    public void drive() {
        System.out.println("Driving CAR");
    }
}
