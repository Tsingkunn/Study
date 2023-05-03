package practice.copy;

import java.util.Objects;

public class CopyConstructorPerson {

    private String name;
    private int age;

    public CopyConstructorPerson( CopyConstructorPerson copyConstructorPerson) {
        this.name = copyConstructorPerson.name;
        this.age = copyConstructorPerson.age;
    }

    public CopyConstructorPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CopyConstructorPerson that = (CopyConstructorPerson) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
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
}
