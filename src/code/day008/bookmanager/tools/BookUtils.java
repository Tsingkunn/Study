package code.day008.bookmanager.tools;

import code.day008.bookmanager.dao.BookDAO;
import code.day008.bookmanager.entity.Book;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BookUtils implements Comparator<Book> {
    public final static Scanner scan = new Scanner(System.in);
    private final BookDAO bookDAO = new BookDAO();
    public static boolean isLoop = true;

    public static void print() {
        System.out.println("图书编号\t\t\t图书名称\t\t\t作者\t\t\t\t人气\t\t\t\t图书类型\t\t\t是否完结");
    }

    public static void print(List<Book> list) {
        print();
        for (Book book : list) {
            print(boxedBook(book));
        }
    }

    public static void print(List<Book> list, int endIndex) {
        print();
        for (int i = 0; i < endIndex; i++) {
            print(boxedBook(list.get(i)));
        }
    }

    public static void print(Book book) {
        print(boxedBook(book));
    }

    public static void print(String str) {
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

    @Override
    public int compare(Book book1, Book book2) {
        return book2.getPop() - book1.getPop();
    }

    public boolean isBidExist(String bid) {

        for (Book book : bookDAO.selectAllBookInfo()) {
            if (bid.equals(book.getBid())) {
                return true;
            }
        }
        return false;
    }

    public List<Book> descendingSort(List<Book> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).getPop() < list.get(j + 1).getPop()) {
                    Book temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }
}
