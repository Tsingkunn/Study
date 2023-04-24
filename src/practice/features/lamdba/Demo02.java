package practice.features.lamdba;

import java.util.function.IntBinaryOperator;

public class Demo02 {
    static int a = 10;
    static int b = 20;

    public static void main(String[] args) {

        // IntBinaryOperator 是一个接口,接口内只有一个""抽象方法"".
        // calculateNum 方法中传入了一个匿名内部类的对象
        int sum1 = calculateNum(new IntBinaryOperator() {
            // 现在我们要实现这个方法.
            // 这段代码其实就是匿名内部类的写法
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        System.out.println("匿名内部类写法: " + sum1);

        // lambda 优化
        int sum2 = calculateNum((int left, int right) -> {
            return left + right;
        });

        System.out.println("lambda写法: " + sum2);

        // 进一步优化
        // 现在我们要实现这个方法.
// 这段代码其实就是匿名内部类的写法
        int sum3 = calculateNum((left, right) -> left + right);
        System.out.println("引用方法写法:" + sum3);

    }

    // 把一个匿名内部类作为参数
    public static int calculateNum(IntBinaryOperator operator) {
        return operator.applyAsInt(a, b);
    }
}
