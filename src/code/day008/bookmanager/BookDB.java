package code.day008.bookmanager;


import java.util.ArrayList;
import java.util.List;

public class BookDB {

    private static final List<Book> bookList;
    
    static {
        Book book1 = new Book("10011", "光阴之外", "耳根", 109000, "仙侠", 2);
        Book book2 = new Book("10012", "姑娘请留步", "天蚕土豆", 7162, "玄幻", 2);
        Book book3 = new Book("10013", "太初", "高楼大厦", 68000, "玄幻", 1);
        Book book4 = new Book("10014", "仙宫", "打眼", 210000, "仙侠", 2);
        Book book5 = new Book("10015", "天才相师", "打眼", 80100, "都市", 2);
        Book book6 = new Book("10016", "一念永恒", "耳根", 577000, "仙侠", 2);

        bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
    }

    public static List<Book> getBookList() {
        return bookList;
    }
}
