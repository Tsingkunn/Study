package practice.string;

import java.util.Arrays;
import java.util.List;

public class Split {

    public static void main(String[] args) {

        // String str1 = "a.|b.c";
        // List<String> list = Arrays.stream(str1.split("|")).toList();
        // list.forEach(System.out::println);
        //
        // String str2 = new String("abc");
        // String str3 = "abc";
        //
        // System.out.println(str2 == str3);
        // System.out.println(str2.equals(str3));
        // str2.intern();

        // String s1 = "123";
        // String s2 = "123";
        // s1.intern();
        // System.out.println(s1 == s2);
        String s1 = new String("123");
        String s2 = s1.intern();
        System.out.println(s1 == s2);
    }
}
