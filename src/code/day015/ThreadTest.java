
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
        MyThreadCounter tc = new MyThreadCounter();
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    tc.add();
                }
            });
        }

        System.out.println(tc.getCount());
    }
}
