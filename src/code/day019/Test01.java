package code.day019;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test01 {
    static int num = 1;
    private Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();

    public void fun1() throws InterruptedException {

        while (true) {
            lock.lock();
            if (num != 1)
                c1.await();
            System.out.println("花儿开了!");
            c2.signal();
            num = 2;
            lock.unlock();
        }

    }

    public void fun2() throws InterruptedException {
        while (true) {
            lock.lock();
            if (num != 2)
                c2.await();
            System.out.println("花儿谢了!");
            c1.signal();
            num = 1;
            lock.unlock();
        }

    }
}
