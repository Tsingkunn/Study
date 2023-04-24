package practice.Preview;

import java.util.Scanner;

/**
 * 猜随机数
 */
public class Job8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int r = (int) (Math.random() * 10) + 1;

        while (true) {
            System.out.print("请输入一个10以内的正整数：");
            int num = scan.nextInt();
            if (num > 10 || num < 1) {
                System.out.println("输入数字区间不合理，请重新输入!");
                // continue 结束当前循环。继续执行当前循环体的下次循环
                continue;
            }
            if (num < r) {
                System.out.println("输入的数字比随机数小！");
            } else if (num > r) {
                System.out.println("输入的数字比随机数大！");
            } else {
                System.out.println("恭喜你猜对了！随机数是：" + num);
                scan.close();
                break;
            }
        }

        // 理解continue
        for (int i = 0; i < 5; i++) {
            if (i == 3)
                continue;
            System.out.println(i);
        }

    }
}
