package code.day010;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Author {
    private String name;

    private List<Book> books;
}
