package practice.array;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyListedListTest {
    public static void main(String[] args) {
        System.out.println("链表模拟-------------------------------------------");
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        // 链表初始值
        System.out.println("链表的值为:\t\t\t" + list);
        System.out.println("链表长度为:\t\t\t" + list.size());

        // 头删除
        boolean b1 = list.removeFirst();
        System.out.println("删除头元素:\t\t\t" + (b1 ? "成功" : "失败"));

        // 尾删除
        boolean b2 = list.removeLast();
        System.out.println("删除尾元素:\t\t\t" + (b2 ? "成功" : "失败"));

        // 打印结果
        System.out.println("链表的值为:\t\t\t" + list);

        // 删除下标'5'的元素
        Integer i1 = list.remove(5);
        System.out.println("删除下标'5'的元素:\t\t" + (i1));

        // 打印结果
        System.out.println("链表的值为:\t\t\t" + list);

        // 删除数值'7'的元素
        boolean b4 = list.removeBy(7);
        System.out.println("删除数值'7'的元素:\t\t" + (b4 ? "成功" : "失败"));

        list.add(3, 18);
        list.add(6, 18);
        list.add(0, 18);
        // 打印结果
        System.out.println("链表随机插入值'18'*3:\t" + list);
        boolean b5 = list.removeIf(value -> value == 18);
        System.out.println("断言值为'18'全部删除:\t" + (b5 ? "成功" : "失败") + "\t 链表值:" + list);
        // 链表操作之后长度确认
        System.out.println("链表长度为:\t\t\t" + list.size());

        // 修改下标[3]的元素,更改其值为99
        boolean b6 = list.set(3, 99);
        System.out.println("修改[3]的值为99:\t\t" + (b6 ? "成功" : "失败") + " 队列值为:" + list);

        // '3'的下标是
        int index = list.indexOf(3);
        System.out.println("值'3'的下标是:\t\t" + index);

        // 最后结果
        System.out.println("链表的值为:\t\t\t" + list);

        // 模拟双向队列
        System.out.println("双向队列模拟-------------------------------------------");
        // 头入队
        boolean b7 = list.offerFirst(99);
        System.out.println("队列头插'99':\t\t" + (b7 ? "成功" : "失败") + " 队列值为:" + list);

        // 尾入队
        boolean b8 = list.offerLast(98);
        System.out.println("队列尾插'98':\t\t" + (b8 ? "成功" : "失败") + " 队列值为:" + list);

        // 检索头尾
        Integer i2 = list.peekFirst();
        System.out.println("队列头部检索值为:\t" + i2 + "\t队列值为:" + list);
        Integer i3 = list.peekLast();
        System.out.println("队列尾部检索值为:\t" + i3 + "\t队列值为:" + list);

        // 头尾出队列
        Integer i4 = list.pollFirst();
        System.out.println("头部出队列值:\t\t" + i4 + "\t队列值为:" + list);
        Integer i5 = list.pollLast();
        System.out.println("尾部出队列值:\t\t" + i5 + "\t队列值为:" + list);

        System.out.println("模拟栈-------------------------------------");

        // 入栈
        list.push(66);
        list.push(66);
        list.push(66);
        list.push(66);
        System.out.println("连续四次入栈'66',值为:\t" + list);

        // 出栈
        list.pop();
        list.pop();
        Integer i6 = list.pop();
        System.out.println("第三次出栈值为:\t" + i6 + "\t栈值为:" + list);

        // 查询栈顶元素
        Integer i7 = list.element();
        System.out.println("查询栈顶元素值为:\t" + i7 + "\t栈值为:" + list);

        //重写foreach
        System.out.print("重写for-each,从尾至头遍历: ");
        list.forEach(v -> System.out.print(v + " "));
        System.out.println();

        System.out.println("链表元素:\t" + list);
        System.out.println("链表长度:\t" + list.size());

        list.addLast(99);
        list.addLast(99);
        list.addLast(99);
        list.addLast(99);
        list.addLast(99);
        System.out.println("链表元素:\t" + list);
        // 迭代器
        Iterator<Integer> it = list.iterator();
        // 迭代器迭代输出
        while (it.hasNext()) {
            int num = it.next();
            if (num == 99) {
                it.remove();
            }
        }

        System.out.println("\n利用迭代器删除元素'99'  ↓");
        System.out.println("链表元素:\t" + list);
        System.out.println("链表长度:\t" + list.size());

        list.clear();
        System.out.println("清空元素:\t" + list);
    }
}
