package code.day008.test02;

public class Car extends Vehicle {
    public Car() {
        super.wheel = "Car有四个轮子";
    }

    @Override
    public void addOil() {
        System.out.println("Car 加油了");
    }
}
