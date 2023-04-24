package practice.Preview;

import java.util.Scanner;

public class Job6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = "a sequence string";

        String[] people = {"张三", "李四", "王五"};

        String name1 = "李四";
        String name2 = "";

        boolean flag = false;

        // 找出元音的个数，charAt 是找字符串中地（i-1）个字符。
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                num++;
            }
        }
        System.out.println("字符中元音的数量为：" + num);

        // 字符的比较是基本数据类型比较，是直接用等于号的
        for (String person : people) {
            if (person.charAt(0) == '张') {
                System.out.println("人名：" + person);
            }
        }

        // subString是实例化一个新的字符串，其堆栈地址是一个新的地址。
        // subString有两种重载方法 1.（begin,end） 2.(begin)
        for (String person : people) {
            if (person.substring(0, 1).equals("张")) {
                System.out.println("人名：" + person);
            }
        }
        // 如果没有新的实例化一个字符串，那么其引用都指向一个相同的堆栈地址，所以可以用等于来比较。
        // 也就是说 == 是比较两个内容的值的堆栈地址。而equals比较的两个内容的值
        String n1 = "张";
        String n2 = new String("张");
        System.out.println(n2 == n1);
        System.out.println(n1 == "张");

        for (int i = 0; i < people.length; i++) {
            // 在这里 people[i].equals(name1） 与 people[i] == name1 从结果上来说是等价的。
            // 因为在程序编译前，people[i] 与 name1 指向同一个堆栈地址
            if (people[i].equals(name1)) {
                System.out.println(name1 + "位于第" + (i + 1) + "个");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("查无此人!");
        }

        flag = false;
        // 从键盘键入的名字，等于new String("xxx");新实例化一个对象
        System.out.print("请输入人名：");
        name2 = scan.nextLine();
        for (int i = 0; i < people.length; i++) {
            if (people[i].equals(name2)) {
                System.out.println(name2 + "位于第" + (i + 1) + "个");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("查无此人!");
        }
        scan.close();
    }
}
