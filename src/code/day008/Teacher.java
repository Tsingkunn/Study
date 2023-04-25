package code.day008;

public class Teacher extends Person {
    String x = "";

    public Teacher() {
        // 如果省略不写super() ,那么默认第一行会调用父类的构造方法
        super();
    }

    public Teacher(String name, String gender) {
        super(name, gender);
    }

    public void showInfo() {
        System.out.println(super.name);
        System.out.println(super.gender);
        this.x = "123";
        System.out.println(this.x);
        super.eat();
    }


    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        teacher.showInfo();
    }
}
