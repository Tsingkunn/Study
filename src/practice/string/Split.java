package practice.string;

import java.util.Arrays;
import java.util.List;

public class Split {

    public static void main(String[] args) {
        
        String str1 = "a.|b.c";
        List<String> list = Arrays.stream(str1.split("|")).toList();
        list.forEach(System.out::println);
    }
}
