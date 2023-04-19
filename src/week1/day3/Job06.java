package week1.day3;

import java.util.Arrays;
import java.util.Scanner;

public class Job06 {
    public static void main(String[] args) {
        String[] arr = { "电水壶", "百岁山", "电视机", "恒大冰泉", "电饭煲", "农夫山泉", "电动牙刷", "电火锅" };

        Scanner scan = new Scanner(System.in);

        System.out.println("请输入一个下标:");
        int index = scan.nextInt();

        if (index < 0 || index >= arr.length) {
            System.out.println("输入的不合法");
        } else {
            System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
            arr = Arrays.copyOf(arr, arr.length - 1);
        }

        for (String string : arr) {
            System.out.println(string);
        }
        // System.out.println("请输入产品名称:");
        // String prod = scan.next();
        // String[] arr2 = new String[arr.length + 1];
        // for (int i = 0; i < arr.length; i++) {
        // arr2[i] = arr[i];
        // }
        // arr2[arr2.length - 1] = prod;
        // arr = arr2;
        // for (String string : arr) {
        // System.out.println(string);
        // }

        // for (String pro : arr) {
        // if (pro.endsWith("泉")) {
        // System.out.println(pro);
        // }
        // }
        // for (String pro : arr) {
        // if (pro.length() == 3) {
        // System.out.println(pro);
        // }
        // }

        // for (String pro : arr) {
        // if (pro.contains("山")) {
        // System.out.println(pro);
        // }
        // }

        scan.close();
    }
}
