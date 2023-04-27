package code.day009;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private String name;

    private int age;

    private String addr;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, addr);
    }

    public Student(String name, int age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public int compareTo(Student student) {
        if (this.getAge() == student.getAge()) {
            return -1;
        }
        return this.getAge() - student.getAge();
    }
}
