package code.day008.test02;

public class Test {
    void run(Vehicle vehicle) {
        System.out.println(vehicle.wheel);
    }

    // return new Car()
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicle("by");
        //= new By()
        
        Test test = new Test();

        test.run(vehicle);
        vehicle.addOil();

    }
}
