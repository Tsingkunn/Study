package practice.features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo01 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 5};

        Arrays.stream(arr)
                .distinct()
                .filter(integer -> integer > 3)
                .forEach(System.out::println);

        Stream.of(arr)
                .distinct()
                .forEach(System.out::println);

        List<String> str = Arrays.asList("a", "b", "c");

        str.stream().forEach(System.out::println);
    }
}
