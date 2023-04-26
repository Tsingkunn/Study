package code.day008.bookmanager;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BookUtils {
    public final static Scanner scan = new Scanner(System.in);

    public static boolean isLoop = true;

    static void print() {
        System.out.println("图书编号\t\t\t图书名称\t\t\t作者\t\t\t\t人气\t\t\t\t图书类型\t\t\t是否完结");
    }

    static public void print(List<Book> list) {
        print();
        for (Book book : list) {
            print(boxedBook(book));
        }
    }

    static public void print(List<Book> list, int endIndex) {
        print();
        for (int i = 0; i < endIndex; i++) {
            print(boxedBook(list.get(i)));
        }
    }

    static public void print(Book book) {
        print(boxedBook(book));
    }

    static void print(String str) {
        System.out.println(str);
    }

    private static String boxedBook(Book book) {
        String bid = String.format("%-12s\t", book.getBid());
        String name = String.format("%-12s\t", book.getName());
        String author = String.format("%-12s\t", book.getAuthor());
        String pop = String.format("%-12s\t", book.getPop());
        String type = String.format("%-12s\t", book.getType());
        String isOver = String.format("%-12s\t", book.getIsOver() == 1 ? "完结" : "连载中");
        return bid + name + author + pop + type + isOver;
    }
}
