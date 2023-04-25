package code.day008.test;

public class Geese extends Bird {
    @Override
    public void layEggs() {
        System.out.println("大雁下蛋了!");
    }

    @Override
    public void fly() {
        System.out.println("大雁飞了!");
    }
}
