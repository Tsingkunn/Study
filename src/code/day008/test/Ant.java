package code.day008.test;

public class Ant extends Insect {
    @Override
    public void spawning() {
        System.out.println("蚂蚁产卵了!");
    }

    @Override
    public void fly() {
        System.out.println("蚂蚁飞了!");
    }
}
