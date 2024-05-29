package Factory;


public class FactoryClient {

    VehicleFactory vehicleFactory;

    public FactoryClient(VehicleFactory vehicleFactory) {
        this.vehicleFactory = vehicleFactory;
    }
    public static void main(String args[]){
        FactoryClient obj = new FactoryClient(new VehicleFactory());
        obj.driveVehicle("truck");
        obj.driveVehicle("bus");
    }

    public void driveVehicle(String type) {
        IVehicle vehicle = vehicleFactory.getVehicle(type);
        vehicle.drive();
    }
}
