package practice.features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class ReduceTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(20, 10);
        Integer sum = list.stream().reduce(1, Integer::divideUnsigned);

        System.out.println(sum);
    }
}
