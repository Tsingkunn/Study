package code.day002;

import java.util.Scanner;

public class Job6 {
    public static void main(String[] args) {
        questionOne();
        System.out.println();
        int nums[] = questionTwo();
        System.out.println();
        questionTree(nums);
        System.out.println();
        questionFour();
    }

    public static void questionOne() {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        System.out.println("{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }的数字之和是：" + sum);
    }

    public static int[] questionTwo() {
        int nums[] = new int[100];

        for (int j = 0; j < nums.length; j++) {
            nums[j] = j + 1;
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        return nums;
    }

    public static void questionTree(int[] nums) {
        int j = 0;
        for (int n : nums) {
            if (n % 5 == 0) {
                System.out.print(n + "\t");
                j++;
                if (j % 3 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    public static void questionFour() {
        Scanner scan = new Scanner(System.in);
        String[] names = new String[5];

        for (int j = 0; j < names.length; j++) {
            System.out.println("请输入学生姓名：");
            names[j] = scan.nextLine();
        }

        for (String name : names) {
            System.out.print(name + " ");
        }
        scan.close();
    }
}
