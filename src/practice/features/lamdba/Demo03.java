package practice.features.lamdba;

import java.util.function.IntPredicate;

public class Demo03 {
    public static void main(String[] args) {
        printNum(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value % 2 == 0;
            }
        });

        printNum((int value) -> {
            return value % 2 == 0;
        });

        printNum(value -> value % 2 == 0);
    }

    public static void printNum(IntPredicate predicate) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }
}
