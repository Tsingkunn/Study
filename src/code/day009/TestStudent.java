package code.day009;

import java.util.Comparator;
import java.util.TreeSet;

public class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student("小A", 18, "成都");
        Student student2 = new Student("小A", 18, "成都");
        Student student3 = new Student("小C", 19, "成都");
        Student student4 = new Student("小D", 19, "成都");
        Student student5 = new Student("小E", 19, "成都");
        Student student6 = new Student("小F", 19, "成都");
        Student student7 = new Student("小G", 19, "成都");
        Student student8 = new Student("小H", 19, "成都");
        
        TreeSet<Student> set = new TreeSet<>();

        set.add(student1);
        set.add(student2);
        set.add(student3);
        set.add(student4);
        set.add(student5);
        set.add(student6);
        set.add(student7);
        set.add(student8);

        set.forEach(System.out::println);
    }
}
