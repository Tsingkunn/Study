package code.day002;

import java.util.Scanner;

/**
 * 手动输入5个数字，找到最大值
 */
public class Job4 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int nums[] = new int[5];

        int max = Integer.MIN_VALUE;

        System.out.print("Please input 5 numbers: ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scan.nextInt();
        }

        for (int num : nums) {
            max = num > max ? num : max;
        }

        System.out.println("The max number is " + max);

        // for (int i = 0; i < nums.length - 1; i++) {
        // nums[0] = nums[i] > nums[i + 1] ? nums[i] : nums[i + 1];
        // }

        // System.out.println("The max number is " + nums[0]);

        scan.close();
    }
}
