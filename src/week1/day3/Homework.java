package week1.day3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1.查询所有学生信息?
 * 2.添加一个学生信息
 * 3.请问男同学有多少个?
 * 4.请问20 - 22之间的同学有哪些?
 * 5.根据学生姓名进行查询学生的信息
 */
public class Homework {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String stuArr[] = { "10023-张三-20-男", "10024-夏雨-22-男", "10025-夏天-23-男", "10026-刘亦菲-20-女", "10027-夏雨-21-女" };

        // 一:查询所有学生信息
        System.out.println("显示所有学生信息:");
        System.out.println("学号\t姓名\t年龄\t性别");
        for (String info : stuArr) {
            String[] student = info.split("-"); // 分割学生信息.(基本每次输入都用到了此方法,用来精细化输出)
            System.out.println(student[0] + "\t" + student[1] + "\t" + student[2] + "\t" + student[3]);
        }

        System.out.println();

        // 二:添加一个学生信息
        System.out.println("...录入一个学生信息...");
        boolean exist = false; // 用于判断学号是否重复.
        System.out.println("请输入学号:");
        int no = -1; // 定义学号,为int类型.限制用户输入
        do {
            no = scan.nextInt(); // 每次进入循环都让用户进行输入
            exist = false; // 每次重新输入前重置一次exist为false
            if (no <= 0) {
                exist = true;// 如果学号存在,将exit置换为true
                System.out.println("学号信息输入有误,请重新输入:");
                continue;
            }
            for (String stu : stuArr) {
                if (stu.split("-")[0].equals(no + "")) {
                    exist = true;// 如果学号存在,将exit置换为true
                    System.out.println("学号已存在,请重新输入:");
                    break; // 若存在,跳出for循环
                }
            }
        } while (exist); // 如果没有重复学号,则跳出循环

        System.out.println("请输入姓名:");
        String name = scan.next(); // 定义姓名,为String类型,随便输入

        System.out.println("请输入一个年龄:");
        int age = -1; // 定义年龄为int类型,并初始化为-1

        // do-while 无论如何都让用户先输入一次
        do {
            age = scan.nextInt();
            if (age < 0) { // 判断用户输入的年龄,如果年龄小于0,就让其一直重新输入
                System.out.println("请重新输入年龄:");
            }
        } while (age < 0);

        System.out.println("请输入性别:");
        String gender = ""; // 定义性别为String .初始化为""

        // do-while 无论如何都让用户先输入一次
        do {
            gender = scan.next();
            // 限制输入只能为"男"或"女",输入错误则一直重新输入
            if (!gender.equals("男") && !gender.equals("女")) {
                System.out.println("请重新输入性别");
            }
        } while (!gender.equals("男") && !gender.equals("女"));

        // 拼接学生信息
        String stu = no + "-" + name + "-" + age + "-" + gender;

        // 扩容并添加新的学生信息
        stuArr = Arrays.copyOf(stuArr, stuArr.length + 1);
        stuArr[stuArr.length - 1] = stu;

        // 打印学生信息
        System.out.println("添加学生信息成功:");
        System.out.println("学号\t姓名\t年龄\t性别");
        for (String info : stuArr) {
            String[] student = info.split("-");
            System.out.println(student[0] + "\t" + student[1] + "\t" + student[2] + "\t" + student[3]);
        }

        System.out.println();
        System.out.println();

        // 三:请问男同学有多少个?

        int countMan = 0; // 男生数量计数器

        for (String info : stuArr) {
            String[] student = info.split("-");
            // 1.这个if语句用来判断是否是男生.
            // 2.这个if语句用来控制输出美化用的,只有第一次打印"学号 姓名 年龄 性别"
            if (student[3].equals("男") && countMan == 0) {
                System.out.println("查询到到如下信息...");
                System.out.println("学号\t姓名\t年龄\t性别");
                System.out.println(student[0] + "\t" + student[1] + "\t" + student[2] + "\t" + student[3]);

                countMan++; // 如果是男生countMan自增

            } else if (student[3].equals("男")) {

                countMan++;// 如果是男生countMan自增

                System.out.println(student[0] + "\t" + student[1] + "\t" + student[2] + "\t" + student[3]);
            }
        }

        // 输出男生数量
        System.out.println("班级里男同学有:" + countMan + "个");

        System.out.println();

        // 四:请问20 - 22之间的同学有哪些?

        int countAge = 0; // 学生年龄计数器

        for (String info : stuArr) {
            String[] student = info.split("-");
            // 1.这个if语句用来判断年龄区间的
            // 2.这个if语句同样是用来控制美化输出的.只有存在学生,并且是第一次输出信息才会输出"学号 姓名 年龄 性别"
            if (Integer.parseInt(student[2]) >= 20 && Integer.parseInt(student[2]) <= 22 && countAge == 0) {
                System.out.println("查询到到如下信息...");
                System.out.println("学号\t姓名\t年龄\t性别");
                System.out.println(student[0] + "\t" + student[1] + "\t" + student[2] + "\t" + student[3]);

                countAge++; // 如果年龄在区间内,则countAge自增1

            } else if (Integer.parseInt(student[2]) >= 20) {
                System.out.println(student[0] + "\t" + student[1] + "\t" + student[2] + "\t" + student[3]);

                countAge++;// 如果年龄在区间内,则countAge自增1
            }
        }

        // 输出学生数量信息
        System.out.println("班级里年龄在20-22之间的学生有:" + countAge + "个");

        System.out.println();

        // 根据学生姓名进行查询学生的信息
        System.out.println("请输入查询人姓名:");
        String searchName = scan.next(); // 定义一个用户输入姓名,为String类型

        int flagOutput = 0; // 用来记录输出了几次
        boolean flagHave = false; // 用来标记是否在学生信息中查询到学生信息,默认无记录

        for (String info : stuArr) {
            String[] student = info.split("-"); // 分割学生信息

            // 1.这个if用来判断是否找到该学生
            // 2.这个if用来判断是否第一次输出,第一次输出则多打印两条信息
            if (student[1].equals(searchName) && flagOutput == 0) {
                System.out.println("查询到到如下信息...");
                System.out.println("学号\t姓名\t年龄\t性别");
                System.out.println(student[0] + "\t" + student[1] + "\t" + student[2] + "\t" + student[3]);
                flagOutput++; // 输出学生信息数量自增1
                flagHave = true; // 只要找到此人,就标记信息中有记录
            } else if (student[1].equals(searchName)) {
                System.out.println(student[0] + "\t" + student[1] + "\t" + student[2] + "\t" + student[3]);
                flagOutput++; // 输出学生信息数量自增1
                flagHave = true;// 只要找到此人,就标记信息中有记录
            }
        }

        // 如果没有该学生信息,则打印查无此人,并且没有标题记录
        if (!flagHave) {
            System.out.println("查无此人!");
        }

        scan.close();
    }
}
