package code.day008;

public class Person {
    String name;

    String gender;

    public Person() {
        System.out.println("无参构造");
    }

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public void eat() {
        System.out.println("吃---");
    }
}
