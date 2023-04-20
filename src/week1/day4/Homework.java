package week1.day4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1.获取所有的"海鲜"商品,并输出.
 * 2.请问"水果"类型有几个?
 * 3.查询金额大于200的商品有哪些？
 * 4.输出100-1000区间的商品有哪些?
 * 5.添加一条商品信息？
 * 6.根据下标删除一条商品信息？
 * 
 */
public class Homework {
    static String[] foods = { "猫山榴莲-水果-2000", "波士顿龙虾-海鲜-600", "梭子蟹-海鲜-80", "人参果-水果-30", "大黄鱼-海产-3000" };
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // 循环控制
        boolean isLoop = true;

        // 利用死循环保持程序一直在运行,
        while (isLoop) {
            // 每次循环开始都展示首页
            showMainPage();
            // 键入选项
            int selection = scan.nextInt();

            // 依据用户键入数字1~7来实现不同的功能,否则,则提示暂无此功能
            switch (selection) {
                case 1 -> getAll();
                case 2 -> getSeafood();
                case 3 -> getSumOfFruit();
                case 4 -> findCommodityByCost();
                case 5 -> queryByCost();
                case 6 -> addFood();
                case 7 -> deleteFood();
                default -> System.out.println("暂无此功能");

            }
        }

    }

    /**
     * 展示首页操作引导界面
     * 
     */
    static void showMainPage() {
        System.out.println("\n"
                + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n"
                + "┃\t主菜单\t\t\t┃\n"
                + "┃1. 查询所有商品\t\t┃\n"
                + "┃2. 查询海鲜类产品并打印\t┃\n"
                + "┃3. 查询水果品类\t\t┃\n"
                + "┃4. 查询金额200以上的商品\t┃\n"
                + "┃5. 查询金额100-1000之间的商品\t┃\n"
                + "┃6. 添加商品信息\t\t┃\n"
                + "┃7. 根据下标删除商品\t\t┃\n"
                + "┃...请选择对应操作...\t\t┃\n"
                + "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

    }

    /**
     * 1.获取所有商品信息
     */
    public static void getAll() {
        System.out.println("商品名称\t品类\t\t价格");
        // 遍历商品数组
        for (String food : foods) {
            // 因为多种方法都要输出信息,故提取公共部分,整合成标准输出方法
            formatPrint(food);

        }
    }

    /**
     * 2.获取所有的"海鲜"商品,并输出.
     */
    public static void getSeafood() {
        System.out.println("商品名称\t品类\t\t价格");
        // 遍历数组
        for (String food : foods) {
            // 如果商品种类是海鲜,则输出
            if (food.split("-")[1].equals("海鲜")) {
                formatPrint(food);
            }
        }
    }

    /**
     * 33统计水果的品类
     */
    public static void getSumOfFruit() {
        // 水果种类计数器
        int countFruit = 0;
        // 遍历数组
        for (String food : foods) {
            // 如果商品的品类是水果,则水果种类计数器countFruit自增1;
            if (food.split("-")[1].equals("水果")) {
                countFruit++;
            }
        }
        System.out.println("水果的品类是: " + countFruit);
    }

    /**
     * 4.查询金额大于200的商品
     */
    public static void findCommodityByCost() {
        System.out.println("商品名称\t品类\t\t价格");
        // 便利数组
        for (String food : foods) {
            // 如果金额大于200.则输出
            if (Double.parseDouble(food.split("-")[2]) > 200) {
                formatPrint(food);
            }
        }
    }

    /**
     * 5.输出100-1000区间的商品
     */
    public static void queryByCost() {
        // 遍历商品信息
        for (String food : foods) {
            // 获取到商品价格
            double cost = Double.parseDouble(food.split("-")[2]);
            // 如果商品价格在100到1000之间,则输出商品信息
            if (cost > 100 && cost < 1000) {
                formatPrint(food);
            }
        }
    }

    /**
     * 6添加商品信息
     */
    public static void addFood() {

        // 提示并录入商品名称
        System.out.println("请输入名称");
        String name = scan.next();

        // 如果商品不存在,添加改商品,并录入新的商品信息;否则,退出并提示商品已存在!
        if (!isFoodExist(name)) {
            // 录入商品种类,价格
            System.out.println("请输入产品种类:");
            String type = scan.next();
            System.out.println("请输入商品价格");
            double cost = scan.nextDouble();

            // 拼接字符串
            String food = name + "-" + type + "-" + cost;
            // 录入数组
            foods = addElement(foods, food);
        } else {
            System.out.println("商品已存在!");
        }
    }

    /**
     * 7删除商品信息
     */
    public static void deleteFood() {

        // 提示并录入下标
        System.out.println("请输入要删除的下标:");
        int index = scan.nextInt();

        int oldLen = foods.length;
        // 如果下标是有效的,则运行if语句;否则,运行else
        if (isIndexValid(index)) {
            // 暂存删除商品的名称
            String name = foods[index].split("-")[0];
            // 调用删除方法
            foods = delElement(foods, index);
            // 如果数组长度改变,则代表删除成功
            if (oldLen == foods.length + 1) {
                System.out.println("删除" + name + "成功!");
            } else {
                System.out.println("删除" + name + "失败!");
            }
        } else {
            System.out.println("输入下标越界!");
        }
    }

    /**
     * 判断数组下标有无越界
     * 
     * @param index 数组下标
     * @return 如果下标范围合理,返回true;否则,返回false
     */
    private static boolean isIndexValid(int index) {
        // 判断下标是否越界,下标长度在0~length-1之间,则是有效下标,返回true;否则返回false
        if (index >= 0 && index < foods.length) {
            return true;
        }
        return false;
    }

    /**
     * 查询商品数组中是否存在该商品
     * 
     * @param food 要查询的商品名称
     * @return 如果商品存在,返回true,如果不存在,返回false
     */
    private static boolean isFoodExist(String food) {
        // 遍历数组
        for (String f : foods) {
            // 拆分字符串之后定位到商品名称字段,如果与输入的字段相等,商品存在,返回true;否则,返回false
            if (f.split("-")[0].equals(food)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 在末尾追加数组元素
     * 
     * @param arr     需要扩容的数组
     * @param element 需要添加的元素
     * @return 数组
     */
    private static String[] addElement(String[] arr, String element) {
        // 扩容
        arr = Arrays.copyOf(arr, arr.length + 1);
        // 末位追加数据
        arr[arr.length - 1] = element;
        return arr;
    }

    /**
     * 删除数组最后一个元素
     * 
     * @param arr   需要删除元素的数组
     * @param index 需要删除元素的下标
     * @return 返回删除元素之后的数组
     */
    private static String[] delElement(String[] arr, int index) {
        // 剪切
        System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
        // 缩容
        arr = Arrays.copyOf(arr, arr.length - 1);
        return arr;
    }

    /**
     * 格式化输出字符串信息
     * 
     * @param food 单个的foods数组中的字符串,如"泥鳅-水产-155"
     */
    private static void formatPrint(String food) {
        // 将字符串拆分
        String[] info = food.split("-");
        // 将字符遍历输出
        for (String str : info) {
            System.out.print(String.format("%1$-8s", str) + "\t");
        }
        System.out.println();
    }
}
