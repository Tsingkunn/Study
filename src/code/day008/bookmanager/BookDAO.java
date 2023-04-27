package code.day008.bookmanager;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final List<BookEntity> list = new BookDB().getBookList();

    public List<BookEntity> selectAllBookInfo() {
        return list;
    }

    public boolean insertBook(BookEntity bookEntity) {
        return list.add(bookEntity);
    }

    public List<BookEntity> selectBookByXianxia() {
        List<BookEntity> bookEntityList = new ArrayList<>();
        for (BookEntity bookEntity : list) {
            if (bookEntity.getType().equals("仙侠")) {
                bookEntityList.add(bookEntity);
            }
        }
        return bookEntityList;
    }

    public List<BookEntity> selectBookByAuthor() {
        List<BookEntity> bookEntityList = new ArrayList<>();
        for (BookEntity bookEntity : list) {
            if (bookEntity.getAuthor().length() == 2) {
                bookEntityList.add(bookEntity);
            }
        }
        return bookEntityList;
    }

    public List<BookEntity> selectBookByNotOver() {
        List<BookEntity> bookEntityList = new ArrayList<>();
        for (BookEntity bookEntity : list) {
            if (bookEntity.getIsOver() == 2) {
                bookEntityList.add(bookEntity);
            }
        }
        return bookEntityList;
    }

    public List<BookEntity> selectBookByPopFiftyThousands() {
        List<BookEntity> bookEntityList = new ArrayList<>();
        for (BookEntity bookEntity : list) {
            if (bookEntity.getPop() > 50000) {
                bookEntityList.add(bookEntity);
            }
        }
        return bookEntityList;
    }
}
