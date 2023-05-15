package code.day016.reflect;

public class Person {

    public String name;
    private Integer age;

    public Person() {
        System.out.println("-----------Persons-------------");
    }

    private Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void showInfo() {
        System.out.println("name : " + name);
        System.out.println("age : " + age);
    }
}
