package code.day002;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        workOne();
        // workTow();
        // workThree();
    }

    public static void workOne() {
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

    public static void workTow() {
        Scanner scan = new Scanner(System.in);
        int cpu = (int) (Math.random() * 3) + 1;
        int flag = 0;

        System.out.println("该你出拳了(1:石头,2:剪刀,3:布)");
        flag = scan.nextInt();

        if (flag == 1) {
            if (flag + cpu == 2) {
                System.out.println("你出了石头,cpu出了石头,平!");
            } else if (flag + cpu == 3) {
                System.out.println("你出了石头,cpu出了剪刀,你赢!");
            } else if (flag + cpu == 4) {
                System.out.println("你除了石头,cpu出了布,cpu赢!");
            }
        } else if (flag == 2) {
            if (flag + cpu == 3) {
                System.out.println("你出了剪刀,cpu出了石头,cpu赢");
            } else if (flag + cpu == 4) {
                System.out.println("你出了剪刀,cpu出了剪刀,平");
            } else if (flag + cpu == 5) {
                System.out.println("你出了剪刀,cpu出了布,你赢");
            }
        } else if (flag == 3) {
            if (flag + cpu == 4) {
                System.out.println("你出了布,cpu出了石头,你赢");
            } else if (flag + cpu == 5) {
                System.out.println("你出了布,cpu出了剪刀,cpu赢");
            } else if (flag + cpu == 6) {
                System.out.println("你出了布,cpu出了布,平");
            }
        } else {
            System.out.println("输入的猜拳数字不合理");
        }

        scan.close();
    }

    public static void workThree() {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        boolean flag = false;
        number = scan.nextInt();

        for (int i = 2; i < number / 2; i++) {
            flag = number % 2 == 0 ? true : false;
            if (flag)
                break;
        }

        if (flag) {
            System.out.println(number + "不是素数");
        } else {
            System.out.println(number + "是素数");
        }
        scan.close();
    }
}
