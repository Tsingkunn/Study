package code.day001;

public class Job1 {

    /**
     * @param args
     * @description Day 001 Homework:
     * 1. To input a right-angled triangle
     * 2. TO
     */
    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i > j) {
                    System.out.print("* ");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

        System.out.println();

        /*
         * 说实话，可能真没有那么复杂，先输出空白，再输出星号。自己属实想多了。
         * ----*----
         * ---***---
         * --*****--
         * -*******-
         * *********
         * 不是上面那样的
         * ----*
         * ---***
         * --*****
         * -*******
         * *********
         * 是这样的
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < (2 * (i + 1) - 1); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < 3; i++) {
            if (i == 0 || i == 2) {
                System.out.println("*\t*\t*\t*\t*\t*\t*");
            } else {
                System.out.println("*\t*\t*控制台计算器:\t*\t*\t*");
            }
        }

        System.out.println();

        int a = 3, b = 9;
        System.out.println("a=" + a + "b=" + b);
        // 0011
        // 1001
        a = a ^ b; // 1010
        b = a ^ b; // 0011
        a = a ^ b; // 1001
        System.out.println("swap");
        System.out.println("a=" + a + ";b=" + b);

        System.out.println();

        // &位运算符，安位与运算
        // 3 & 9
        // 0011 & 1001
        // 0001
        System.out.println("3 & 9 =" + (3 & 9));

        int c = 1;
        int d = 1;
        int c1 = 0, d1 = 0;
        c1 = c++; // 先赋值，后运算
        d1 = ++d; // 先运算，后赋值
        System.out.println("c1=" + c1 + "\nd1=" + d1);

        System.out.println();

        int num = 15;
        if (num % 2 == 0) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }

        if (num > 18) {
            System.out.println(num + "is illegal.");
        } else {
            System.out.println(num + "is not illegal.");
        }

        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println(num + " is a multiple of 3 and 5.");
        } else {
            System.out.println(num + " is not a multiple of 3 and 5.");
        }

    }
}
