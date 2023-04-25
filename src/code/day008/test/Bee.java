package code.day008.test;

public class Bee extends Insect {
    @Override
    public void spawning() {
        System.out.println("蜜蜂产卵了!");
    }

    @Override
    public void fly() {
        System.out.println("蜜蜂飞了!");
    }
}
