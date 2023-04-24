package code.day005;

import java.util.Scanner;

public class Job1 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数:");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        if (isPrime(number)) {
            System.out.println(number + " 是素数");
        } else {
            System.out.println(number + " 不是素数");
        }

    }

    /**
     * 判断一个数是否是素数
     *
     * @param number 一个 {@code int} 类型的数字
     * @return 一个布尔值: 如果 number 是素数,返回 true ;否则,返回 false.
     */
    private static boolean isPrime(int number) {
        if (number > 1) {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
