package code.day008.test02;

public class Test {
    void run(Vehicle vehicle) {
        System.out.println(vehicle.wheel);
    }


    public static void main(String[] args) {
        // return new Car()
        //
        Vehicle vehicle = VehicleFactory.getVehicle("car");

        Test test = new Test();

        test.run(vehicle);
        vehicle.addOil();

    }
}
