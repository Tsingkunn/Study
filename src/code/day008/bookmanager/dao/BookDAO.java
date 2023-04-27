package code.day008.bookmanager.dao;

import code.day008.bookmanager.db.BookDB;
import code.day008.bookmanager.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final List<Book> list = new BookDB().getBookList();

    public List<Book> selectAllBookInfo() {
        return list;
    }

    public boolean insertBook(Book book) {
        return list.add(book);
    }

    public List<Book> selectBookByXianxia() {
        List<Book> bookList = new ArrayList<>();
        for (Book book : list) {
            if (book.getType().equals("仙侠")) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    public List<Book> selectBookByAuthor() {
        List<Book> bookList = new ArrayList<>();
        for (Book book : list) {
            if (book.getAuthor().length() == 2) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    public List<Book> selectBookByNotOver() {
        List<Book> bookList = new ArrayList<>();
        for (Book book : list) {
            if (book.getIsOver() == 2) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    public List<Book> selectBookByPopFiftyThousands() {
        List<Book> bookList = new ArrayList<>();
        for (Book book : list) {
            if (book.getPop() > 50000) {
                bookList.add(book);
            }
        }
        return bookList;
    }
}
