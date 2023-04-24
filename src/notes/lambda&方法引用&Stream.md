# lambda,方法引用,Stream

Lambda 表达式可以看作一个执行策略, 方法引用让你能更加清楚执行了什么策略

---

## 1. lambda

#### 使用前提

匿名内部类是一个接口,且匿名内部类中只有一个""抽象方法"".

#### 格式

    ( Agrs... )->{ StatementBlock }

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
        Integer result1 = typeConvert(new Function<String, Integer>() {
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
        String result2 = typeConvert((String str) -> {
            return str + "::太酷啦!";
        });

        System.out.println(result2);


    }

    public static <R> R typeConvert(Function<String, R> function) {
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

# 3. Stream

## 1. 创建流

#### 单列集合(父接口 Collection): 集合对象.stream();

```java
class Demo {
    public void test() {
        // 集合中的每个元素都是作家
        // 那么流中的每个元素也是作家
        List<Author> authors = getAuthors();

        authors.stream()
                .distinct()
                .filter(author -> author.getAge() > 18)
                .foreach(System.out::println);
    }
}
```

#### 数组

```java
class Demo {
    private static void test02() {

        Integer[] arr = {1, 2, 3, 4, 5, 5};

        Arrays.stream(arr)
                .distinct()
                .filter(integer -> integer > 3)
                .forEach(System.out::println);

        // (T... values) 可变参数在底层就是以数组实现的
        Stream.of(arr)
                .distinct()
                .forEach(System.out::println);
    }
}
```

#### 双列集合(父接口 Mapper)

```java
class Demo {
    private static void test03() {
        Map<String, Integer> map = new HashMap<>();
        map.put("蜡笔小新", 20);
        map.put("黑子", 19);
        map.put("日向", 18);

        // map.entrySet() 将双列集合变成单列集合.
        // 每一个元素都是一个实体,里面包含K-V信息.
        // 可以通过entry.getKey()和entry.getValue()来回获取键值对信息
        map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 18)
                .forEach(System.out::println);

        // 使用keySet来转换成单列集合
        map.keySet()
                .stream()
                .filter(entry -> entry.equals("蜡笔小新"))
                .forEach(System.out::println);
    }
}
```

## 2. 中间操作

#### filter: 过滤操作,符合条件的留下,不符合条件的抛弃

```java
List<Author> authors=getAuthors();
        ...
        .filter(new Predicate<Author>(){
@Override
public boolean test(Author author){
        // 如果为true,可以记录留在流里面
        // 如果为false,则被抛弃
        return false;
        }
        })
        ...

        .filter((arg)->{})
```

###### 示例如下

```java
class Demo {
    private static void test04() {
        List<Author> authors = getAuthors();
        authors.stream()
                // 过滤掉作家名字长度小于等于1的.留下作家名字长度大于1的
                .filter(author -> author.getName().length() > 1)
                .forEach(System.out::println);
    }
}
```

#### map: 映射操作,将什么映射成什么

```java
class Demo {
    private static void test05() {
        List<Author> authors = getAuthors();

        authors.stream()
                // 把author转换成字符串
                // 参数是两个泛型,把第一个泛型转换成第二个泛型
                .map(new Function<Author, String>() {
                    public String apply(Author author) {

                        return author.getName();
                    }
                }).forEach(System.out::println);

        authors.stream()
                .map(Author::getName)
                .forEach(System.out::println);
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age + 10)
                .forEach(System.out::println);
    }
}
```

#### distinct: 去掉流中的重复元素

> 这里 distinct()方法是依赖 Object 的 equals()方法来来判断是否是相同对象的,所以要注意重写 equals()方法.
> 在 Object 的 equals()方法中,只==来判断两个数是否是相同地址来判断是否是相同元素的

```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

在类里面注解@EqualsAndHashCode 相当于重写了 equals()与 hashCode()

```java
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id && Objects.equals(name, author.name) && Objects.equals(age, author.age) && Objects.equals(intro, author.intro) && Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, intro, books);
    }
```
