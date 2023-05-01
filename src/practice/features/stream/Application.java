package practice.features.stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        test08();
    }

    private static void test08() {
        List<Author> authors = getAuthors();
        authors.stream()
                .collect(Collectors.toMap(Author::getName, Author::getBooks, (oldValue, newValue) -> oldValue))
                .forEach((k, v) -> System.out.println(k + ":" + v));
    }

    private static void test07() {
        List<Author> authors = getAuthors();
        // 去重,降序排序
        authors.stream().distinct().sorted().forEach(System.out::println);

    }

    private static void test06() {
        List<Author> authors = getAuthors();

        authors.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private static void test05() {
        List<Author> authors = getAuthors();

        authors.stream()
                .map(author -> author.getAge() + 10)
//                .map(age -> age + 10)
                .forEach(System.out::println);

        // authors.stream()
        // 把author转换成字符串
        // 参数是两个泛型,把第一个泛型转换成第二个泛型
        // .map(Author::getName)
        // .forEach(System.out::println);
    }

    private static void test04() {
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(author -> author.getName().length() > 1)
                .forEach(System.out::println);
    }

    private static void test02() {
        Integer[] arr = {1, 2, 3, 4, 5, 5};
        Arrays.stream(arr)
                .distinct()
                .filter(integer -> integer > 3)
                .forEach(System.out::println);

        // (T... values) 可变参数在底层就是以数组实现的
        Stream.of(arr).distinct().forEach(System.out::println);
    }

    private static void test03() {
        Map<String, Integer> map = new HashMap<>();
        map.put("蜡笔小新", 20);
        map.put("黑子", 19);
        map.put("日向", 18);

        map.keySet()
                .stream()
                .filter(entry -> entry.equals("蜡笔小新"))
                .forEach(System.out::println);

        map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 18)
                .forEach(System.out::println);
    }

    public static void test01(List<Author> authors) {
        authors.stream() // 把集合转换成流
                .distinct() // 去重
                .filter(author -> author.getAge() < 18) // 过滤
                .forEach(author -> System.out.println(author.getName())); // 遍历;
    }

    private static List<Author> getAuthors() {
        Author author1 = new Author(1L, "蒙多", 33, "一个从菜刀中明悟的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追不上他思考的速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 155, "是这个世界在限制他的思维", null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维领略世界尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维领略世界尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的世界理解"));

        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个剑客对他的情侣竟然这么宽容"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家精神与肉体上的碰撞会激起怎样的火花呢?"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家精神与肉体上的碰撞会激起怎样的火花呢?"));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author1, author2, author3, author4));

        return authorList;
    }

}
