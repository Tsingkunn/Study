package code.day008.test;

public class Pigeon extends Bird {

    @Override
    public void layEggs() {
        System.out.println("鸽子下单了.");
    }

    @Override
    public void fly() {
        System.out.println("鸽子飞了!");
    }
}
