package Preview;

import java.util.Scanner;

/**
 * 计算输入学生成绩的平均值
 */
public class Job7 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        float sum = 0, score = 0;

        // while(true) 则会一直运行
        do {
            System.out.println("请输入学生成绩,输入-1退出:");
            score = scan.nextInt();
            if (score != -1) {
                sum += score;
                i++;
            }
        } while (score != -1);

        // while (score != -1) {
        // System.out.println("请输入学生成绩,输入-1退出:");
        // score = scan.nextInt();
        // if (score != -1) {
        // sum += score;
        // i++;
        // }
        // }

        // 最好还是别用下面面这种方法，对于循环条件不确定的，用while或者do-while可能更好一些。
        //
        // for (;; i++) {
        // System.out.println("请输入学生的成绩：，输入-1退出:");
        // score = scan.nextFloat();
        // if (score == -1) {
        // break;
        // }
        // sum += score;
        // }

        if (i == 0) {
            System.out.println("已退出。");
        } else {
            System.out.println("学生的平均成绩为：" + (float) (sum / i));
        }

        scan.close();

    }
}
