package features.internal.run;

import features.internal.test.Test;

public class App {
    public static void main(String[] args) {
        new Test() {
            @Override
            protected void print() {
                super.print();
            }
        }.print();
    }
}
