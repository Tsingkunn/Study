package code.day016;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CommunicationTest {

    static int num = 1;

    private static Lock lock = new ReentrantLock();

    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();

    private static Object obj = new Object();

    static class Fun1 extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (num != 1)
                        c1.await();
                    System.out.println("花儿开了");
                    num = 2;
                    c2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }

    static class Fun2 extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (num != 2)
                        c2.await();
                    System.out.println("花儿谢了");
                    num = 1;
                    c1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                ;
            }
        }
    }

    static class Fun3 extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (obj) {
                    try {
                        if (num != 2)
                            obj.wait();
                        System.out.println("花儿开了");
                        num = 1;
                        obj.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Fun4 extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (obj) {
                    try {
                        if (num != 1) {
                            obj.wait();
                        } else {
                            System.out.println("花儿谢了");
                            num = 2;
                            obj.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
