package code.day003;

import java.util.Scanner;

/**
 * 模拟银行的登录取钱
 */
public class Job5 {
    public static void main(String[] args) {
        // 默认账户
        String USERNAME1 = "user";
        String PASSWORD1 = "pwd";

        // 默认存款金额
        int saving = 3000;

        // 系统退出标志
        int exit = 0;
        Scanner scan = new Scanner(System.in);
        // 用一个do-while循环来模拟程序一直运行
        do {
            // 显示主界面
            System.out.println("*\t*\t*\t*\t欢迎登陆中国银行*\t*\t*\t*\t\t");
            System.out.println("*\t*\t*\t*\t 请选择如下操作 *\t*\t*\t*\t\t");
            System.out.println("*\t*\t*\t*\t*    1.登录\t*\t*\t*\t*\t");
            System.out.println("*\t*\t*\t*\t*    2.退出\t*\t*\t*\t*\t");
            // 登录,退出
            int flag = 0;

            // 登录,退出输入合法性判断,不合法一直输入
            do {
                flag = scan.nextInt();
                if (flag > 2 || flag < 1) {
                    System.out.println("无效操作!!");
                }
            } while (flag > 2 || flag < 1);

            // 登录
            if (flag == 1) {
                // 登录之后需要提示输入用户名和密码
                for (int i = 2; i >= 0; i--) {
                    System.out.println("*\t*\t*\t*\t 请输入用户名 *\t*\t*\t*\t\t");
                    String username = scan.next();
                    System.out.println("*\t*\t*\t*\t 请输入密 码 *\t*\t*\t*\t\t");
                    String password = scan.next();
                    // 判断用户输入是否正确
                    if (username.equals(USERNAME1) && password.equals(PASSWORD1)) {
                        int exitPersonInfo = 0;
                        do {
                            // 个人界面
                            System.out.println("*\t*\t*\t*\t*    1.取款\t*\t*\t*\t*\t");
                            System.out.println("*\t*\t*\t*\t*    2.存款\t*\t*\t*\t*\t");
                            System.out.println("*\t*\t*\t*\t*    3.查询余额\t*\t*\t*\t*\t");
                            System.out.println("*\t*\t*\t*\t*    4.返回主界面\t*\t*\t*\t*\t");
                            System.out.println("*\t*\t*\t*\t*    5.退出程序\t*\t*\t*\t*\t");

                            // 个人界面操作标志
                            int money = 0;

                            // 输入合法性判断,不合法为无效操作
                            do {
                                money = scan.nextInt();
                                if (money > 5 || money < 1) {
                                    System.out.println("无效操作!!");
                                }
                            } while (money > 5 || money < 1);

                            if (money == 1) { // 取款
                                System.out.println("请输入取款金额!");
                                int getMoney = 0;
                                getMoney = scan.nextInt();
                                // 取款步骤:
                                // 1.输入取款金额
                                // 2.与余额相比对
                                // 3.如果小于余额,那么则直接取出
                                // 4.若取出金额大于余额,则不能全部取出
                                // 4.1之后,询问是否要全部取出
                                if (getMoney > 0) {
                                    if (getMoney > saving) {
                                        System.out.println("您现在余额为" + saving + "元,无法取走" + getMoney + "元.是否要全部取出?");
                                        System.out.println("1.是\t2.否");
                                        int get = 0;
                                        do {
                                            get = scan.nextInt();
                                            if (get != 1) {
                                                System.out.println("无效操作!!");
                                            }
                                        } while (get != 1);
                                        if (get == 1) {
                                            System.out.println("正在清点...请稍后...已取出" + saving + "元.");
                                            System.out.println("请从机械口中取走钱币.携带好随身物品,谨防丢失!");
                                            saving = 0;
                                        }
                                    } else {
                                        System.out.println("正在清点...请稍后...已取出" + getMoney + "元.");
                                        saving -= getMoney;
                                        System.out.println("请从机械口中取走钱币.携带好随身物品,谨防丢失!");
                                    }
                                } else {
                                    System.out.println("输入错误!请输入合法金额!");
                                }
                            } else if (money == 2) { // 存款
                                // 模拟存款步骤,这里默认每次都放了1000元人民币
                                System.out.println("请将钱币放入机械口中...");
                                System.out.println("清点中...请稍后...");
                                saving += 1000;
                                System.out.println("您已存入1000元.");
                            } else if (money == 3) { // 查看余额
                                System.out.println("您当前的余额为" + saving + "元.");
                            } else if (money == 4) {
                                exitPersonInfo = 1; // 退出个人信息界面
                            } else {
                                exit = 1; // 退出整个系统
                                break; // 跳出个人界面的死循环
                            }
                        } while (exitPersonInfo != 1);

                        break;
                    } else { // 用户名或密码输入不正确
                        // 当用户名密码不正确时,提示还有几次输入机会
                        // 当机会全部用光时,冻结输入的用户名的账户
                        if (i != 0) {
                            System.out.println("你还有" + i + "次机会");
                        } else {
                            System.out.println("无法输入,账户" + username + "已被冻结,即将退回主界面");
                        }
                    }
                }
            } else {
                // 退出do-while循环,模拟退出整个系统
                System.out.println("*\t*\t*\t*\t 欢迎下次光临\t*\t*\t*\t*\t\t");
                exit = 1;
            }
        } while (exit != 1);

        scan.close();
    }
}
