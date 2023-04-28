package practice.compare;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class Person implements Comparable<Person> {
    String name;
    int age;

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
