package code.day007;

public class Job02 {
    static String name;
    int age;

    public Job02(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Job02 j1 = new Job02("晓峰", 20);
        Job02 j2 = new Job02("圆圆", 16);

        System.out.println(j1.name);
        System.out.println(j1.age);
        System.out.println(j2.name);
        System.out.println(j2.age);

    }
}
