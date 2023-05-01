package code.day010;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToMapTest {


    public static void main(String[] args) {
        List<Author> authors = getAuthors();

        System.out.println("toMap");
        authors.stream()
                .collect(Collectors.toMap(Author::getName, Author::getBooks, (oldValue, newValue) -> oldValue))
                .forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("-----------------------------------------");
        System.out.println("groupingBy");
        authors.stream()
                .collect(Collectors.groupingBy(Author::getName))
                .forEach((k, v) -> System.out.println(k + " : " + v));
    }

    private static List<Author> getAuthors() {
        List<Book> books1 = new ArrayList<>();
        Book book1 = new Book("斗罗大陆");
        Book book2 = new Book("冰火魔厨");
        books1.add(book1);
        books1.add(book2);
        Author author1 = new Author("唐三", books1);

        Author author2 = new Author("唐三", books1);

        List<Book> books2 = new ArrayList<>();
        Book book3 = new Book("斗破苍穹");
        Book book4 = new Book("武动乾坤");
        books2.add(book3);
        books2.add(book4);

        Author author3 = new Author("天蚕土豆", books2);

        List<Author> list = new ArrayList<>();

        list.add(author1);
        list.add(author2);
        list.add(author3);

        return list;
    }
}
