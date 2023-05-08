package code.day010.entity;

import java.io.Serializable;
import java.util.Objects;

public class University implements Serializable {
    // 大学名称
    private String uname;

    // 大学所在城市
    private String city;

    // 办学性质: 0 民办,1 公办
    private String type;

    // 学校文理性质
    private String subject;

    // 录取批次
    private String batch;

    // 最高分
    private float topScore;

    // 排名
    private int rank;

    public University() {
    }

    public University(String uname, String city, String type, String subject, String batch, float topScore, int rank) {
        this.uname = uname;
        this.city = city;
        this.type = type;
        this.subject = subject;
        this.batch = batch;
        this.topScore = topScore;
        this.rank = rank;
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public float getTopScore() {
        return topScore;
    }

    public void setTopScore(float topScore) {
        this.topScore = topScore;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "University{" +
                "uname='" + uname + '\'' +
                ", city='" + city + '\'' +
                ", type=" + type +
                ", subject=" + subject +
                ", batch='" + batch + '\'' +
                ", topScore='" + topScore + '\'' +
                ", rank=" + rank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(type, that.type) && Objects.equals(subject, that.subject) && rank == that.rank && Objects.equals(uname, that.uname) && Objects.equals(city, that.city) && Objects.equals(batch, that.batch) && Objects.equals(topScore, that.topScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uname, city, type, subject, batch, topScore, rank);
    }

}
