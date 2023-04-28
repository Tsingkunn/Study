package practice.copy;

import java.io.*;

public class Writer implements Cloneable, Serializable {
    private String name;
    private Book book;

    public Writer(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    public Writer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public Writer clone() {
        try {
            return (Writer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


}
