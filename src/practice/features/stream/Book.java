package practice.features.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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
}
