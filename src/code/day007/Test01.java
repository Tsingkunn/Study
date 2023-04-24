package code.day007;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        int[] nums = {};

        System.out.println(sumNumber(nums));

        String str = "asdasohLHLHOIHLKHDlsahlkdashlkdlkHLHdlkas";

        System.out.println(Arrays.toString(findUpperChar(str)));
    }

    public static int sumNumber(int[] arr) {
        if (arr.length == 0) {
            throw new RuntimeException("输入数组为空!");
        }

        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static char[] findUpperChar(String str) {
        char[] charArr = {};
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
//            if (str.charAt(i) > 64 && str.charAt(i) < 91) {
                charArr = Arrays.copyOf(charArr, charArr.length + 1);
                charArr[charArr.length - 1] = str.charAt(i);
            }
        }
        return charArr;
    }
}
