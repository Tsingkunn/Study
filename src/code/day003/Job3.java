package code.day003;

/**
 * 打印所用的四叶玫瑰数;
 */
public class Job3 {
    /**
     * @param args
     */
    public static void main(String[] args) {

        int ones = 0;
        int tens = 0;
        int hundreds = 0;
        int thousands = 0;

        int power = 4;

        for (int number = 1000; number < 10000; number++) {
            ones = number % 10;
            tens = number % 100 / 10;
            hundreds = number % 1000 / 100;
            thousands = number / 1000;

            if (Math.pow(ones, power) + Math.pow(tens, power) + Math.pow(hundreds, power)
                    + Math.pow(thousands, power) == number) {
                System.out.println(number + " 是一个四叶玫瑰数!");
            }
        }

    }
}
