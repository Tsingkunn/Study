package code.day008.test02;

public class VehicleFactory {
    static Vehicle getVehicle(String type) {
        if (type.equals("car")) {
            return new Car();
        } else if (type.equals("bus")) {
            return new Bus();
        } else {
            return null;
        }
    }
}
