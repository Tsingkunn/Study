package code.day002;

public class Job1 {
    public static void main(String[] args) {
        int a = 3;
        int b = 9;

        int c;

        c = a;
        a = b;
        b = c;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
