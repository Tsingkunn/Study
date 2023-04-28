package code.day008.bookmanager.dao;

import code.day008.bookmanager.db.BookDB;
import code.day008.bookmanager.entity.Book;
import code.day008.bookmanager.tools.BookUtils;

import java.util.*;
import java.util.stream.Collectors;

public class BookDAO {
    private final List<Book> list = new BookDB().getBookList();

    public List<Book> selectAllBookInfo() {
        return list;
    }

    public boolean insertBook(Book book) {
        return list.add(book);
    }

    public Book deleteBook(String bid) {
        Iterator<Book> it = list.iterator();
        Book delBook = null;
        while (it.hasNext()) {
            delBook = it.next();
            System.out.println("bid::" + bid);
            System.out.println("delBook bid" + delBook.getBid());
            if (delBook.getBid().equals(bid)) {
                it.remove();
                break;
            }
        }
        return delBook;
    }

    public List<Book> selectTopBookByXianxia() {
        List<Book> bookList = new ArrayList<>();
        int maxPopBook = -1;
        for (Book book : list) {
            if (book.getType().equals("仙侠")) {
                if (book.getPop() > maxPopBook) {
                    maxPopBook = book.getPop();
                    bookList.clear();
                    bookList.add(book);
                } else if (book.getPop() == maxPopBook) {
                    bookList.add(book);
                }
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

    public int selectBookByNotOver() {


        int sumPop = 0;
        int countPop = 0;
        for (Book book : list) {
            if (book.getIsOver() == 2) {
                countPop++;
                sumPop += book.getPop();
            }
        }
        if (countPop == 0) {
            return -1;
        } else {
            return sumPop / countPop;
        }
    }

    public List<Book> selectBookByNotOverTopThreeFromNotOver() {
        List<Book> bookList = new ArrayList<>();
        for (Book book : list) {
            if (book.getIsOver() == 2) {
                bookList.add(book);
            }
        }

        bookList = new BookUtils().descendingSort(bookList);
        return bookList.subList(0, 3);
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

    public Map<String, List<Book>> selectBookInfoByKind() {

        return list.stream().collect(Collectors.groupingBy(Book::getType));
    }

    public boolean isBidExist(String bid) {
        for (Book book : selectAllBookInfo()) {
            if (bid.equals(book.getBid())) {
                return true;
            }
        }
        return false;
    }

}
