package practice.features.stream;

import java.util.List;
import java.util.Objects;

public class Author {

    // id
    private long id;
    // 名字
    private String name;
    // 年龄
    private Integer age;
    // 简介
    private String intro;
    // 作品
    private List<Book> books;

    public Author() {
    }

    public Author(long id, String name, Integer age, String intro, List<Book> books) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.intro = intro;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id && Objects.equals(name, author.name) && Objects.equals(age, author.age) && Objects.equals(intro, author.intro) && Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, intro, books);
    }
}
