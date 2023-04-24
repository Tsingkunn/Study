package code.day007;

public class Test02 {
    public static void main(String[] args) {
        Teacher t = new Teacher();

        t.tid = "12345";
        t.age = 22;
        t.gender = "女";
        t.name = "倩倩";

        System.out.println(t.name);
        t.eat();
    }
}
