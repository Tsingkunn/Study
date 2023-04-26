package code.day009;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cc");
        list.add("aa");
        list.add("cc");
        list.add("bb");
        list.add("cc");
        Iterator<String> it = list.iterator();

        list.remove("");
        while (it.hasNext()) {
            if (it.next().equals("cc")) {
                it.remove();
            }
        }

        list.forEach(System.out::println);
    }
}
