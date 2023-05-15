package code.day020;

public class App {
    public static void main(String[] args) {
        VolatileTest vt = new VolatileTest();

        new Thread(() -> vt.printA()).start();

        new Thread(() -> vt.printB()).start();
    }
}
