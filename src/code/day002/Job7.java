package week1.day2;

import java.util.Scanner;

/**
 * 1.判断年龄是否合法
 * 2.判断一个数是否是3和五的公倍数
 */
public class Job7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 判断年龄是否合法
        System.out.print("请输入一个年龄：");
        int age = scan.nextInt();

        if (age < 1 || age > 256) {
            System.out.println("输入的年龄不合法");
        } else {
            System.out.println("你输入的年龄为：" + age);
        }

        System.out.println();

        // 判断一个数是否是3，5的公倍数
        System.out.print("请输入一个整数：");
        int num = scan.nextInt();

        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println(num + " 是3和5的公倍数.");
        } else {
            System.out.println(num + " 不是3和5的公倍数.");
        }

        scan.close();
    }
}
