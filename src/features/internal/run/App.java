package features.internal.run;

import features.internal.test.Test;

public class App {
    public static void main(String[] args) {
        // 匿名内部类
        new Test() {
            @Override
            protected void print() {
                super.print();
            }
        }.print();
    }
}
