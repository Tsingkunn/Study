package code.day008.bookmanager;


import java.util.ArrayList;
import java.util.List;

public class BookDB {

    private final List<BookEntity> bookEntityList = new ArrayList<>();

    public List<BookEntity> getBookList() {
        return bookEntityList;
    }

    public BookDB() {
        init();
    }

    private void init() {
        BookEntity bookEntity1 = new BookEntity("10011", "光阴之外", "耳根", 109000, "仙侠", 2);
        BookEntity bookEntity2 = new BookEntity("10012", "姑娘请留步", "天蚕土豆", 7162, "玄幻", 2);
        BookEntity bookEntity3 = new BookEntity("10013", "太初", "高楼大厦", 68000, "玄幻", 1);
        BookEntity bookEntity4 = new BookEntity("10014", "仙宫", "打眼", 210000, "仙侠", 2);
        BookEntity bookEntity5 = new BookEntity("10015", "天才相师", "打眼", 80100, "都市", 2);
        BookEntity bookEntity6 = new BookEntity("10016", "一念永恒", "耳根", 577000, "仙侠", 2);

        bookEntityList.add(bookEntity1);
        bookEntityList.add(bookEntity2);
        bookEntityList.add(bookEntity3);
        bookEntityList.add(bookEntity4);
        bookEntityList.add(bookEntity5);
        bookEntityList.add(bookEntity6);
    }
}
