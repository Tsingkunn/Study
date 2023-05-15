package code.day019;

public class Test {
    static int num = 1;

    public synchronized void fun1() throws InterruptedException {
        while (true) {
            if (num != 1)
                this.wait();
            System.out.println("花儿开了!");
            this.notify();
            num = 2;
        }
    }

    public void fun2() throws InterruptedException {
        synchronized (this) {
            while (true) {
                if (num != 2)
                    this.wait();
                System.out.println("花儿谢了!");
                this.notify();
                num = 1;
            }
        }
    }
}
