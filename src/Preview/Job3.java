package Preview;

import java.util.Scanner;

public class Job3 {
    public static void main(String[] args) {
        // int[] scores = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        Scanner scan = new Scanner(System.in);

        int numOfStudent = 0;
        System.out.print("请输入学生的数量：");
        numOfStudent = scan.nextInt();

        int scores[] = new int[numOfStudent];
        for (int i = 0; i < numOfStudent; ++i) {
            System.out.print("请输入第" + (i + 1) + "个学生的成绩：");
            scores[i] = scan.nextInt();
        }

        int sum = 0;
        for (int score : scores) {
            // 累加的推荐写法,累减、累乘、累除同理
            sum += score;
        }
        System.out.println("学生总成绩为：" + sum);

        double avg = 0d;
        avg = (double) sum / (double) numOfStudent;
        System.out.println("学生的平均成绩为：" + avg);

        int numOfFail = 0;
        for (int score : scores) {
            if (score < 60) {
                numOfFail++;
            }
        }

        System.out.println("不及格的学生人数为：" + numOfFail);
        scan.close();

        // float f = 1.2 小数的默认范围是double, float f = 1.2f; 或者 double d = 1.2
        // 基本数据类型
        // byte io字节流时候会用（1个字节8位）
        // byte， short ，int ，long， float， double， char， boolean
        // long l = 100L; 100L才是long，100是int
        // 小范围类型能自动转换成大范围类型数据；大范围类型数据可强制转换为小类型数据。

        long num1 = 100L;
        int num2 = (int) num1;
        num1 = num2;
    }
}
