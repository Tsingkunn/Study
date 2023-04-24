package code.day002;

import java.util.Scanner;

/**
 * 请输入一个月份，判断这个月份对应的季节
 */

enum Season {
    Spring, Summer, Fall, Winter, ErrorMonth;
}

public class Job3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int season;

        // 输入一个月份，如果月份不合理，重新输入
        System.out.print("Please input a month:");
        do {
            season = scan.nextInt();
            if (season < 1 || season > 12) {
                System.out.print("Illegal month!Please re-input a month:");
            }
        } while (season < 1 || season > 12);

        // 判断月份对应季节
        if (season >= 1 && season <= 3) {
            System.out.println(Season.Spring);
        } else if (season >= 4 && season <= 6) {
            System.out.println(Season.Summer);
        } else if (season >= 6 && season <= 8) {
            System.out.println(Season.Fall);
        } else if (season >= 9 && season <= 12) {
            System.out.println(Season.Winter);
        } else {
            System.out.println(Season.ErrorMonth);
        }

        scan.close();
    }
}
