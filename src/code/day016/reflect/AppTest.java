package code.day016.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppTest {

    public static void main(String[] args) throws Exception {

        Lock lock = new ReentrantLock();

        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        // 获取类对象
        Class<Person> clazz = Person.class;
        // 获取构造器(全部的)
        Constructor<Person> con = clazz.getDeclaredConstructor(String.class, Integer.class);
        // 设置私有构造器也是可以获取的
        con.setAccessible(true);
        // 根据获取的构造器实例化对象
        Person person = (Person) con.newInstance("园园", 98);

        // 调用Person中的方法
        person.showInfo();

        // 获取所有字段
        Field[] fields = clazz.getDeclaredFields();

        // 打印字段信息
        for (Field field : fields) {
            System.out.println(field.getName());
            field.setAccessible(true);
        }

        fields[0].set(person, "倩倩");
        fields[1].set(person, 19);
        person.showInfo();
    }

    // private static void getClassObj() throws ClassNotFoundException {
    // Class c1 = Person.class;

    // Person p = new Person();
    // Class c2 = p.getClass();

    // Class c3 = Class.forName("code.day016.reflect.Person");

    // System.out.println(c1);
    // System.out.println(c2);
    // System.out.println(c3);
    // }
}
