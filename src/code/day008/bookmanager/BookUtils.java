package code.day008.bookmanager;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BookUtils implements Comparator<BookEntity> {
    public final static Scanner scan = new Scanner(System.in);
    private final BookDAO bookDAO = new BookDAO();
    public static boolean isLoop = true;

    static void print() {
        System.out.println("图书编号\t\t\t图书名称\t\t\t作者\t\t\t\t人气\t\t\t\t图书类型\t\t\t是否完结");
    }

    static public void print(List<BookEntity> list) {
        print();
        for (BookEntity bookEntity : list) {
            print(boxedBook(bookEntity));
        }
    }

    static public void print(List<BookEntity> list, int endIndex) {
        print();
        for (int i = 0; i < endIndex; i++) {
            print(boxedBook(list.get(i)));
        }
    }

    static public void print(BookEntity bookEntity) {
        print(boxedBook(bookEntity));
    }

    static void print(String str) {
        System.out.println(str);
    }

    private static String boxedBook(BookEntity bookEntity) {
        String bid = String.format("%-12s\t", bookEntity.getBid());
        String name = String.format("%-12s\t", bookEntity.getName());
        String author = String.format("%-12s\t", bookEntity.getAuthor());
        String pop = String.format("%-12s\t", bookEntity.getPop());
        String type = String.format("%-12s\t", bookEntity.getType());
        String isOver = String.format("%-12s\t", bookEntity.getIsOver() == 1 ? "完结" : "连载中");
        return bid + name + author + pop + type + isOver;

    }

    @Override
    public int compare(BookEntity bookEntity1, BookEntity bookEntity2) {
        return bookEntity2.getPop() - bookEntity1.getPop();
    }

    public boolean isBidExist(String bid) {

        for (BookEntity bookEntity : bookDAO.selectAllBookInfo()) {
            if (bid.equals(bookEntity.getBid())) {
                return true;
            }
        }
        return false;
    }

    public List<BookEntity> descendingSort(List<BookEntity> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).getPop() < list.get(j + 1).getPop()) {
                    BookEntity temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }
}
