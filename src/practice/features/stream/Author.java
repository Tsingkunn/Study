package practice.features.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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


}
