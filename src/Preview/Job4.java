package Preview;

public class Job4 {
    public static void main(String[] args) {
        int[] numbers = { 8, 32, 5, 456, 234, 867 };

        int numOfOdd = 0, numOfEven = 0;

        for (int number : numbers) {
            if (number % 2 != 0) {
                numOfOdd++;
            } else {
                numOfEven++;
            }
        }
        /*
         * int r = numOfOdd - numOfEven
         * if (r<0) r = -r
         * 或者
         * 三元运算：：变量 = 条件？成立：不成立
         * r = r<0?-r:r
         * Math.abs() 就是三元运算
         */
        int diff = numOfOdd - numOfEven;
        diff = diff < 0 ? -diff : diff;

        System.out.println("奇数与偶数数目之差为：" + diff);

        // 最大值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int number : numbers) {
            if (max < number) {
                max = number;
            }
            if (min > number) {
                min = number;
            }
        }
        System.out.println("最大值是:" + max + "\n最小值是:" + min);

        int num = 8;
        boolean exist = false;

        for (int number : numbers) {
            if (num == number) {
                exist = true;
                break;
            }
        }

        if (exist) {
            System.out.println(num + "存在于数组中");
        } else {
            System.out.println(num + "不存在与数组中");
        }
    }
}
