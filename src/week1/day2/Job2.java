package week1.day2;

import java.util.Scanner;

/**
 * 输入一个学生分数，判断这个分数是否合法
 */
public class Job2 {
    public static void main(String[] args) {
        double score;
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入学生分数：");
        score = scan.nextDouble();

        if (score > 100 || score < 0) {
            System.out.println("分数：" + score + "不合法。");
        } else {
            System.out.println("分数：" + score + "合法。");
        }

        scan.close();
    }
}
