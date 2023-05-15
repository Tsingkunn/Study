package code.day019;

public class AppRun {
    public static void main(String[] args) throws InterruptedException {
        Test01 t1 = new Test01();

        new Thread(() -> {
            try {
                t1.fun1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                t1.fun2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
