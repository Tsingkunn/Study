package code.day008;

public class Student {

    String name;

    String gender;

    public Student() {
        // this 调用构造方法只能在第一行
        this("乔治", "男");
    }

    public Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public void speak() {
        System.out.println("speak!");
    }

    public void showInfo(String name) {
        System.out.println(this.name);
        this.speak();
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.showInfo("");
    }
}
