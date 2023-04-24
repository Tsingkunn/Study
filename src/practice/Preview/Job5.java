package practice.Preview;

/**
 * description: 比较两个数组
 */
public class Job5 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 16, 5};
        int[] nums2 = {1, 2, 3, 4, 5, 6};

        boolean flag = true;

        // 判断两个数组是否相等。
        if (nums1.length == nums2.length) {
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] != nums2[i]) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }

        if (flag) {
            System.out.println("两个数组相等！");
        } else {
            System.out.println("两个数组不相等");
        }

        // 如果数组中的元素是2的倍数，则除以2，直到元素无法被2整除为止。
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 == 0) {
                nums1[i] /= 2;
                // 如果这个数能被2整除，则再次重新从这个数开始循环判断，否则往下循环。
                i--;
            }
        }

        // foreach 循环中的元素都似乎对元素的拷贝，无法获取其引用。
        // for循环中可以通过对特定位置数组元素的引用来修改数组中的元素。
        for (int num1 : nums1) {
            System.out.print(num1 + " ");
        }
    }
}
