package code.day020;

public class VolatileTest {
    private static volatile int count = 0;

    public void printA() {
        while (count < 10) {
            if (count % 2 == 0) {
                System.out.println("A print:" + count);
                synchronized (this) {
                    count++;
                }
            }
        }
    }

    public void printB() {
        while (count < 10) {
            if (count % 2 != 0) {
                System.out.println("B print:" + count);
                synchronized (this) {
                    count++;
                }
            }
        }
    }
}
