package practice.features.stream;

import java.util.*;
import java.util.stream.Collectors;

public class FilterTest {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 1, 4, 6, 3, 1, 5, 3, 2, 2, 4};
        List<Integer> list = Arrays.stream(nums).distinct().toList();

    }
}
