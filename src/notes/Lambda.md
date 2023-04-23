# lambda与方法引用

Lambda表达式可以看作一个执行策略, 方法引用让你能更加清楚执行了什么策略

---

## 1. lambda

#### 使用前提

匿名内部类是一个接口,且匿名内部类中只有一个""抽象方法"".

#### 格式

    ( Agrs... )->{ SatementBlock }

#### 省略规则

1. 参数类型可省略
2. 方法体只有一句代码时.大括号,return,和唯一一句代码的分号可以省略
3. 只有一个参数时.参数的小括号也可以省略

```java
public class Demo01 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类的方法被执行了!");
            }
        }).start();

        // lambda,不关注类名和方法名,只关注参数和方法体;
        new Thread(() -> System.out.println("Lambda方法被执行了!")).start();
    }
}
```

###### Demo02

```java
import java.util.function.IntBinaryOperator;

public class Demo02 {
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

        // 进一步优化
        // 使用引用方法
        // 匿名内部类中实现的方法的参数个数,与引用方法中的参数个数,相同
        int sum4 = calculateNum(Integer::sum);
    }

    // 把一个匿名内部类作为参数
    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }
}
```

###### Demo03

```java
import java.util.function.Function;

public class Demo03 {
    public static void main(String[] args) {
        //匿名内部类写法
        Integer result1 = typeConver(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                // Integer.parseInt(str) 将字符串转换成基本类型int,
                //      自动拆箱,所以可以用 ==,来判断
                // Integer.valueOf(str) 将字符串转换成Integer类型,可以直接对转换的对象调用Integer里面的方法
                //      若数字在 -128~127之间,会直接取缓存,超过则创建新的对象
                //      用integer1.equals(integer2) 来判断是否相等

                return Integer.parseInt(s);
            }
        });
        System.out.println(result1);

        // 泛型,自己定义返回值
        String result2 = typeConver((String str) -> {
            return str + "::太酷啦!";
        });

        System.out.println(result2);


    }

    public static <R> R typeConver(Function<String, R> function) {
        String str = "12345";
        return function.apply(str);
    }
}
```

## 2. 方法引用

#### 格式

    < ClassName or instance >::< MethodName >

---

###### Demo

```java
public class Demo {
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
```

