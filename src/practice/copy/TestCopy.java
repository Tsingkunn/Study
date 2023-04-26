package practice.copy;

public class TestCopy {
    public static void main(String[] args) {
        CopyConstructorPerson p1 = new CopyConstructorPerson("小乔", 18);
        CopyConstructorPerson p2 = new CopyConstructorPerson(p1);
        System.out.println(p2);
        System.out.println(p1);

        Book book1 = new Book("大大的世界", 10);
        Book book2 = new Book("小小的梦想", 40);
    }
}