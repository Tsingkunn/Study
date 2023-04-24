package code.day003;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 删除数组:
 * 重点再与System.arraycopy()和Arrays.copyOf()的应用
 * System.arraycopy() 方法需要传入两个数组,没有返回值
 * Arrays.copyOf() 方法需要传入一个数组,重要的是可以自动缩容与扩容并且返回这个缩容或者扩容之后的数组.
 * 5.String flowerName = {"玫瑰花","雪莲花","兰花","石榴花","栀子花"}
 * //1.手动输入一个花名，添加到数组中。(花名不能重复)
 * //2.根据下标删除花名
 */
public class Job8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] flowerName = {"玫瑰花", "雪莲花", "兰花", "石榴花", "栀子花"};

        boolean exist = false;

        System.out.println("输入一种花的名字吧:");
        String name = scan.next();

        for (String string : flowerName) {
            if (name.equals(string)) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            flowerName = Arrays.copyOf(flowerName, flowerName.length + 1);
            flowerName[flowerName.length - 1] = name;
            System.out.println("好耶~我们现在又多了一种花啦~");
        } else {
            System.out.println("已经有这种花了,还是换一种吧.");
        }

        System.out.print("我们现在有了" + flowerName.length + "种花哦:");
        for (String flower : flowerName) {
            System.out.print(flower + " ");
        }

        System.out.println("\n但是我们现在要丢掉一种花,丢掉哪个呢?(需要输入下标哦,不可以乱输哦~)");

        int index = scan.nextInt();
        String delFlower = "";
        if (index < 0 || index > flowerName.length) {
            System.out.println("都叫你不要乱输啦!");
        } else {
            delFlower = flowerName[index];
            System.arraycopy(flowerName, index + 1, flowerName, index, flowerName.length
                    - 1 - index);
            flowerName = Arrays.copyOf(flowerName, flowerName.length - 1);
        }

        System.out.println("我们丢掉了" + delFlower + ",真是可惜!可不能再这样了.");
        System.out.print("现在,我们就剩这" + flowerName.length + "种花了:");
        for (String flower : flowerName) {
            System.out.print(flower + " ");
        }

        scan.close();
    }
}
