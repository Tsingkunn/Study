package practice.features.stream;

import java.util.Objects;

public class Book {

    // id
    private long id;
    // 书名
    private String name;
    // 分两类
    private String category;
    // 评分
    private Integer score;
    // 简介
    private String intro;

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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", score=" + score +
                ", intro='" + intro + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Book() {

    }

    public Book(long id, String name, String category, Integer score, String intro) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.score = score;
        this.intro = intro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(name, book.name) && Objects.equals(category, book.category) && Objects.equals(score, book.score) && Objects.equals(intro, book.intro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, score, intro);
    }
}
