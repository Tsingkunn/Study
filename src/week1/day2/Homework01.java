package week1.day2;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("请输入两个数字,再输入运算符号(+,-,*,/.):");
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        String c = scan.next();

        if (c.equals("+")) {
            System.out.println(x + " " + c + " " + y + " = " + (x + y));
        } else if (c.equals("-")) {
            System.out.println(x + " " + c + " " + y + " = " + (x - y));
        } else if (c.equals("*")) {
            System.out.println(x + " " + c + " " + y + " = " + (x * y));
        } else if (c.equals("/")) {
            if (y == 0) {
                System.out.println("0不能当除数!");

            } else {
                System.out.println(x + " " + c + " " + y + " = " + (x / y));
            }
        } else {
            System.out.println("输入的运算符错误有误！应为+,-,*,/.");
        }

        scan.close();
    }
}
