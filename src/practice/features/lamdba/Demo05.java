package practice.features.lamdba;

import java.util.ArrayList;
import java.util.List;

public class Demo05 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i > -5; i--) {
            list.add(i);
        }
        // 方法引用: 格式<ClassName | instance>::<MethodName>

        list.stream().map(Math::abs).forEach(System.out::println);

    }

}
