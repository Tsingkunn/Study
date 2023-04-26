package practice.copy;

public class Book implements Cloneable {

    private String name;
    private int age;

    public Book() {
    }

    public Book(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
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
