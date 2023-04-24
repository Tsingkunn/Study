package practice.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnArray {
    public static void main(String[] args) {
        int[] anArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = Arrays.stream(anArray).boxed().collect(Collectors.toList());

        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> li = Arrays.asList(array);

        System.out.println(list);
        System.out.println(li);

        int[] nums = {1, 2, 3, 4, 5, 6};
        String[] str = {"青", "太厉害了"};
        // 利用stream流输出数组.
        Stream.of(str).forEach(num -> System.out.println("字符串是:" + num));
        System.out.println(String.join(", ", str));
        Arrays.stream(str).forEach(System.out::println);

        System.out.println(Arrays.toString(nums));

        // compareTo, equals(), ==
        String str1 = "123";
        String str2 = new String("123");
        String str3 = "1234";
        String str4 = "123";
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareTo(str3));
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);
        System.out.println(str1 == str4);
    }
}
