package code.day008.bookmanager;

import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable<Book> {
    // 图书编号
    private String bid;

    // 图书名称
    private String name;

    // 图书作者
    private String author;

    // 图书人气
    private int pop;

    // 图书类型
    private String type;

    // 是否完结
    private int isOver;

    public Book() {
    }

    public Book(String bid, String name, String author, int pop, String type, int isOver) {
        this.bid = bid;
        this.name = name;
        this.author = author;
        this.pop = pop;
        this.type = type;
        this.isOver = isOver;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIsOver() {
        return isOver;
    }

    public void setIsOver(int isOver) {
        this.isOver = isOver;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pop == book.pop && isOver == book.isOver && Objects.equals(bid, book.bid) && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(type, book.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bid, name, author, pop, type, isOver);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pop=" + pop +
                ", type='" + type + '\'' +
                ", isOver=" + isOver +
                '}';
    }

    @Override
    public int compareTo(Book book) {
        return this.getPop() - book.getPop();
    }
}
