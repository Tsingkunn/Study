package code.day011;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 匿名内部类,没有名的类
 */
public class Test {
    public static void main(String[] args) {
        new A() {
            @Override
            public void fun1() {
                System.out.println("我重写了方法");
            }
        }.fun1();


        // lambda:只关注参数,与返回值
        B b = () -> System.out.println("B接口.匿名");
        b.funB();

        // 实例方法,当第一个参数是"某方法"的调用者,后面的参数(可有可无)是"某方法"的参数时,
        // 就可以使用 实例方法的方法引用, 类名::方法名
        // (str1, str2) -> str1.equals(str2) ==> String::equals
        BiPredicate<String, String> bp = String::equals;
        System.out.println(bp.test("123", "123"));

        // 静态方法,传入的参数都是都是"某方法"的参数.
        // x -> Math.abs(x) ==>  Math::abs
        Function<Long, Long> function = Math::abs;
        System.out.println(function.apply(-133L));

        // 构造方法,
        // () -> new A; ==> A::new
        // (x, y, z) -> new A(x, y, z); ==> A::new
        Supplier<A> supplier = A::new;
        Function<String, A> functionNew = A::new;
        functionNew.apply("qwe");

        // 成员方法,调用的时传入参数的类时,调用该类的方法.
        // (a) -> a.fun1(); ==> A::fun1
        A a = new A();
        Consumer<A> consumerLambda = A::fun1;
        consumerLambda.accept(a);
    }
}
