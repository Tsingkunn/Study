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

        boolean isLoop = true;
        while (isLoop) {
            showMainPage();
            int selection = scan.nextInt();
            switch (selection) {
                case 1 -> getAll();
                case 2 -> getSeafood();
                case 3 -> System.out.println("水果的品类是: " + getSumOfFruit());
                case 4 -> {
                    for (String string : findCommodityByCost()) {
                        System.out.println(string);
                    }
                }
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
        System.out.println(""
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
                + "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

    }

    /**
     * 获取所有商品信息
     */
    public static void getAll() {
        for (String food : foods) {
            System.out.println(food);
        }
    }

    /**
     * 获取所有的"海鲜"商品,并输出.
     */
    public static void getSeafood() {
        for (String food : foods) {
            if (food.split("-")[1].equals("海鲜")) {
                System.out.println(food);
            }
        }
    }

    /**
     * 统计水果的品类
     * 
     * @return 返回水果的品类个数
     */
    public static int getSumOfFruit() {
        int countFruit = 0;
        for (String food : foods) {
            if (food.split("-")[1].equals("水果")) {
                countFruit++;
            }
        }
        return countFruit;
    }

    /**
     * 查询金额大于200的商品
     * 
     * @return 返回一个所查商品的一个数组,如果没查到,返回一个空数组
     */
    public static String[] findCommodityByCost() {
        String[] commodity = {};
        for (String food : foods) {
            if (Double.parseDouble(food.split("-")[2]) > 200) {
                commodity = addElement(commodity, food);
            }
        }
        return commodity;
    }

    /**
     * 输出100-1000区间的商品
     */
    public static void queryByCost() {

        for (String food : foods) {
            double cost = Double.parseDouble(food.split("-")[2]);
            if (cost > 100 && cost < 1000) {
                System.out.println(food);
            }
        }
    }

    /**
     * 添加商品信息
     */
    public static void addFood() {
        System.out.println("请输入名称");
        String name = scan.next();
        if (!isFoodExist(name)) {
            System.out.println("请输入产品种类:");
            String type = scan.next();
            System.out.println("请输入商品价格");
            double cost = scan.nextDouble();

            String food = name + "-" + type + "-" + cost;

            foods = addElement(foods, food);
        } else {
            System.out.println("商品已存在!");
        }
    }

    /**
     * 删除商品信息
     */
    public static void deleteFood() {
        System.out.println("请输入要删除的下标:");
        int index = scan.nextInt();
        int oldLen = foods.length;
        if (isIndexValid(index)) {
            String name = foods[index].split("-")[0];
            foods = delElement(foods, index);
            if (oldLen == foods.length + 1) {
                System.out.println("删除" + name + "成功!");
            } else {
                System.out.println("删除" + name + "失败!");
            }
        }
    }

    /**
     * 判断数组下标有无越界
     * 
     * @param index 数组下标
     * @return 如果下标范围合理,返回true;否则,返回false
     */
    private static boolean isIndexValid(int index) {
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
        for (String f : foods) {
            if (f.split("-")[0].equals(food + "")) {
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
        arr = Arrays.copyOf(arr, arr.length + 1);
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

        System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
        arr = Arrays.copyOf(arr, arr.length - 1);

        System.out.println(arr.length);

        return arr;
    }
}
