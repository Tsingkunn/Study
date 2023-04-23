package features.lamdba;

import java.util.Random;

public class Demo07 {

    // Lambda 表达式都可以看作一个执行策略，方法引用反而让你能更加清楚执行了什么策略
    // 封装过的代码
    // 全程只有方法引用与lambda
    public void randomInt() {
        new Random().ints(10)
                .map(this::selfIncreasing)
                .forEach(System.out::println);

    }

    // 封装
    private int selfIncreasing(int self) {
        System.out.println("self = " + self);
        return self + 1;
    }

    //未封装的代码
    // lambda,方法引用,与普通语句块相混杂
    public void notEncapsulation() {
        new Random().ints(10)
                .map(operand -> {
                    System.out.println("operand = " + operand);
                    return operand + 1;
                })
                .forEach(System.out::println);
    }
}
