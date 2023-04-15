package Preview;

import java.util.Scanner;

public class Job3 {
    public static void main(String[] args) {
        // int[] scores = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        Scanner scan = new Scanner(System.in);

        int num_of_student;
        System.out.print("请输入学生的数量：");
        num_of_student = scan.nextInt();
        int scores[] = new int[num_of_student];

        for (int i = 0; i < num_of_student; ++i) {
            System.out.print("请输入第" + (i + 1) + "个学生的成绩：");
            scores[i] = scan.nextInt();
        }

        int sum = 0;
        for (int score : scores) {
            // 累加的推荐写法,累减、累乘、累除同理
            sum += score;
        }
        System.out.println("学生总成绩为：" + sum);

        // float f = 1.2 小数的默认范围是double, float f = 1.2f; 或者 double d = 1.2
        double avg = 0d;
        avg = (double) sum / (double) num_of_student;
        System.out.println("学生的平均成绩为：" + avg);
        scan.close();
    }
}
