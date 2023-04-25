package practice.features.stream;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Integer> list = Arrays.stream(new int[] { 1, 3, 2, 4, 5, 6, 7 })
                .boxed()
                .filter(x -> x > 3)
                .toList();

        System.out.println(list);
    }
}
