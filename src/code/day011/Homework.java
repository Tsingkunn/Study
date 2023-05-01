package code.day011;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        // 用户输入两个整数a、b。如果a能被b整除或a加b大于1000，则输出a；否则输出b。
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println((a % b == 0) || (a + b > 1000) ? a : b);
    }
}