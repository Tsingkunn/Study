package Preview;

import java.util.Scanner;

/**
 * Count the numbers;
 */
public class Job1 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year, month;
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        System.out.println("请输入年份，月份：");
        year = scanner.nextInt();
        month = scanner.nextInt();

        if (month > 12 || month < 1) {
            System.out.println("请重新输入月份：");
            month = scanner.nextInt();
        }
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            if (month == 2) {
                System.out.println(year + "年是闰年，" + month + "月有" + (days[month - 1] + 1) + "天");
            } else {
                System.out.println(year + "年是闰年，" + month + "月有" + days[month - 1] + "天");
            }
        } else {
            System.out.println(year + "年是平年，" + month + "月有" + days[month - 1] + "天");
        }
        scanner.close();
    }
}
