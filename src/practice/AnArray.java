package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AnArray {
    public static void main(String[] args) {
        int[] anArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        List<Integer> list = Arrays.stream(anArray).boxed().collect(Collectors.toList());

        Integer[] array = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        List<Integer> li = Arrays.asList(array);

        System.out.println(list);
        System.out.println(li);
    }
}
