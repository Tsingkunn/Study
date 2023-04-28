package practice.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        list.add(new Person("小乔A", 18));
        list.add(new Person("小乔B", 16));
        list.add(new Person("小乔C", 17));


        list.sort(Comparator.comparingInt(Person::getAge));
    }
}
