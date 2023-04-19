package week1.day2;

import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cpu = (int) (Math.random() * 3) + 1;
        int flag = 0;

        System.out.println("该你出拳了(1:石头,2:剪刀,3:布)");
        flag = scan.nextInt();

        if (flag < 1 || flag > 3) {
            System.out.println("输入的数字不合理!");
        } else {
            if ((flag == 1 && cpu == 2) || (flag == 2 && cpu == 3) || (flag == 3 && cpu == 1)) {
                System.out.println("你赢了");
            } else if ((flag == 1 && cpu == 1) || (flag == 2 && cpu == 2) || (flag == 3 && cpu == 3)) {
                System.out.println("平局!");
            } else {
                System.out.println("你输了");
            }
        }

        scan.close();
    }
}
