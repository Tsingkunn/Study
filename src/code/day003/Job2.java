package code.day003;

/**
 * 输入一个数,判断它是否是水仙花数;
 */
public class Job2 {
    public static void main(String[] args) {

        int ones = 0;
        int tens = 0;
        int hundreds = 0;

        int power = 3;

        int sum = 0;

        for (int number = 100; number < 1000; number++) {
            ones = number % 10;
            tens = number % 100 / 10;
            hundreds = number / 100;
            if (Math.pow(ones, power) + Math.pow(tens, power) + Math.pow(hundreds, power) == number) {
                sum += number;
            }
        }

        System.out.println("所有水仙花数的和为:" + sum);

    }
}
