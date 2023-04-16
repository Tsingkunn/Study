package Preview;

/**
 * 计算产生1000次[1,10]随机数，计算每个数字的生成数量
 */
public class job9 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < 1000; i++) {
            // num 与 nums[]索引之间的关系
            // nums[index] 来记录 数字（index+1）的数量:nums[0] --> 1
            // num - 1 == nums[index]
            int num = (int) (Math.random() * 10 + 1);
            nums[num - 1]++;
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
