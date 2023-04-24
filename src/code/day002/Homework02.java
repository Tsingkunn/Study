package code.day002;

import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cpu = (int) (Math.random() * 3) + 1;
        int user = 0;

        int count = 10;

        int countWin = 0;
        int countLose = 0;
        int countDraw = 0;
        int countError = 0;

        System.out.println("来玩10次猜拳吧!");

        for (int i = 9; i >= 0; i--) {
            System.out.println("该你出拳了(1:石头,2:剪刀,3:布)");
            user = scan.nextInt();

            if (user < 1 || user > 3) {
                System.out.println("输入的数字不合理!");
                countError++;
                i++;
            } else {
                if ((user == 1 && cpu == 2) || (user == 2 && cpu == 3) || (user == 3 && cpu == 1)) {
                    System.out.println("你出了:" + getFlag(user) + ",电脑出了:" + getFlag(cpu) + ".你赢了!");
                    countWin++;
                } else if (user == cpu) {
                    System.out.println("你出了:" + getFlag(user) + ",电脑出了:" + getFlag(cpu) + "平局!");
                    countDraw++;
                } else {
                    System.out.println("你出了:" + getFlag(user) + ",电脑出了:" + getFlag(cpu) + "你输了!");
                    countLose++;
                }
                if (i != 0) {
                    System.out.println("还剩" + i + "次机会啦!");
                }
            }

            if (i == 0) {
                System.out.println("下次再一起来玩吧!!拜拜!");
            }
        }

        System.out.println("你赢了" + countWin + "次");
        System.out.println("你输了" + countLose + "次");
        System.out.println("你平了" + countDraw + "次");
        if (countError > 0) {
            System.out.println("你乱输入" + countError + "次,下次不可以这样哦!");
        }

        if ((double) (countWin) / count > 0.5) {
            System.out.println("你太强啦!电脑完全不是你的对手呢!!");
        } else {
            System.out.println("也没赢几次嘛!看来你还要继续努力呢!!!");
        }

        scan.close();
    }

    static String getFlag(int num) {
        if (num == 1)
            return "石头";
        else if (num == 2)
            return "剪刀";
        else
            return "布";
    }
}
