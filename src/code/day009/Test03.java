package code.day009;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test03 {

    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        Student student1 = new Student("小A", 18, "成都");
        Student student2 = new Student("小A", 18, "成都");
        Student student3 = new Student("小C", 19, "成都");
        Student student4 = new Student("小D", 19, "成都");
        Student student5 = new Student("小E", 19, "成都");
        Student student6 = new Student("小F", 19, "成都");
        Student student7 = new Student("小G", 19, "成都");
        Student student8 = new Student("小H", 19, "成都");

        map.put(student1.getName(), student1);
        map.put(student2.getName(), student2);
        map.put(student3.getName(), student3);
        map.put(student4.getName(), student4);
        map.put(student5.getName(), student5);
        map.put(student6.getName(), student6);
        map.put(student7.getName(), student7);
        map.put(student8.getName(), student8);
        map.put(null, null);

        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }

        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            map.get(key);
        }
    }
}
