package week1.day2;

/**
 * 定义一个正整数数组，计算其中的偶数和
 */
public class job5 {
    public static void main(String[] args) {
        int[] nums = { 5, 6, 7, 8, 9, 10 };

        int sum = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                sum += num;
            }
            // sum = num % 2 == 0 ? sum + num : sum;
        }

        System.out.println("The even sum is " + sum);
    }
}