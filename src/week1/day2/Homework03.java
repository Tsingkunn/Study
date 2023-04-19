package week1.day2;

import java.util.Scanner;

public class Homework03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        boolean flag = false;

        System.out.println("请输入一个大于1的自然数:");

        number = scan.nextInt();

        for (int i = 2; i <= number / 2; i++) {
            flag = number % i == 0 ? true : false;
            if (flag)
                break;
        }

        if (number > 1 && !flag) {
            System.out.println(number + "是素数");
        } else {
            System.out.println(number + "不是素数");
        }

        scan.close();
    }
}
