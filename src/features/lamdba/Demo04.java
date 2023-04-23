package features.lamdba;

import java.util.function.Function;

public class Demo04 {
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
