package practice.array;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();

        // 初始化数组,字符串 1~9
        for (int i = 0; i < 10; i++) {
            myArrayList1.add(i);
        }
        //打印集合1的初始值
        System.out.println("集合1的初始值: \t\t" + myArrayList1);

        // 迭代器
        // hasNext() / next() / remove()
        // 验证迭代器,遇到3跳出循环
        Iterator<Integer> it = myArrayList1.iterator();
        System.out.print("遇3删除并跳出迭代器循环:");
        found:
        {
            while (it.hasNext()) {
                int num = it.next();
                if (num == 3) {
                    // 重写了迭代器的remove
                    it.remove();
                    // break的标签写法
                    break found;
                } else {
                    System.out.print(num + " ");
                }
            }
        }
        System.out.println("\n迭代器删除了'3'\t\t" + myArrayList1);

        // 删除
        // 删除最后一个
        Integer num1 = myArrayList1.remove();
        System.out.println("删除最后一个元素:\t\t" + num1);

        // 根据下标删除
        Integer num2 = myArrayList1.remove(3);
        System.out.println("删除下标[3]的元素: \t" + num2);

        // 根据对象删除
        boolean isRemove = myArrayList1.removeBy(6);
        System.out.println("删除值'6'是否成功: \t" + (isRemove ? "是" : "否"));

        // 处理后的集合数据
        System.out.println("集合1数组长度是:\t\t" + myArrayList1.size());
        System.out.println("集合1数组元素是:\t\t" + myArrayList1);

        // 初始化第二个数组,指定初始化数组大小为20
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>(20);
        myArrayList2.add(0).add(1).add(2).add(5).add(7).endAdd(8);

        // 打印初始值
        System.out.println("集合2的元素:\t\t\t" + myArrayList2);

        // 验证equals()与hashCode()函数是否匹配
        System.out.println("两个集合是否相等:\t\t" + ((myArrayList2.equals(myArrayList1)) ? "是" : "否"));
        System.out.println("集合1的hashCode():\t" + myArrayList1.hashCode());
        System.out.println("集合2的hashCode():\t" + myArrayList2.hashCode());

        // 插入'12'在下标0的位置
        myArrayList1.set(0, 12);
        System.out.println("集合1[0]位置插入 12:\t" + myArrayList1);

        // 查找元素'12'第一次出现时的下标
        int index = myArrayList1.indexOf(12);
        System.out.println("集合1 12 的下标:\t\t" + index);


        // 添加重复元素,验证removeIf函数是否有效
        for (int i = 0; i < 10; i++) {
            myArrayList1.add(1);
        }
        System.out.println("集合1数组元素是:\t\t" + myArrayList1);
        myArrayList1.removeIf(integer -> integer == 1);
        System.out.println("集合1断言等于1的都删除:\t" + myArrayList1);

        // 清空数组
        myArrayList1.clear();
        System.out.println("清空集合: \t\t\t" + myArrayList1);

        for (int i = 0; i < 10; i++) {
            myArrayList1.endAdd(i);
        }
        // 打印
        // 重写了foreach,
        System.out.println("集合1数组元素是:\t\t" + myArrayList1);
        System.out.print("集合1重写了foreach打印:");
        myArrayList1.forEach(System.out::print);
        new ArrayList<>();
    }
}
