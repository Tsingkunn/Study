package practice.array;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        // 10行5列
        int[] nums = {0, 1, 0, 3, 12};
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[index++] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

}
