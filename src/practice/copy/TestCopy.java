package practice.copy;

import java.io.IOException;

/**
 * Copy
 */
public class TestCopy {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CopyConstructorPerson p1 = new CopyConstructorPerson("小乔", 18);
        CopyConstructorPerson p2 = new CopyConstructorPerson(p1);
        System.out.println(p2);
        System.out.println(p1);

        // 浅拷贝:
        Book book1 = new Book("大大的世界", 99);
//        Book book2 = book1.clone();
        Book book3 = new Book("小小的梦想", 66);
//        System.out.println("book1 : " + book1);
//        System.out.println("book2 : " + book2);
//        System.out.println("book1 name: " + book1.getName());
//        System.out.println("book1 page: " + book1.getPage());
//        book2.setName("小小的梦想");
//        System.out.println("book2 name: " + book2.getName());

        System.out.println("------");
        System.out.println("------");
        System.out.println("------");
        System.out.println("------");

        // 浅拷贝: 浅拷贝中,浅拷贝的克隆对象中,引用类型的字段指向的时同一个
        Writer writer1 = new Writer("倩倩", book1);
        // 浅克隆
//        Writer writer2 = writer1.clone();
        Writer writer2 = (Writer) writer1.deepClone();

        System.out.println("before writer1 : " + writer1);
        System.out.println("before writer1 book addr:" + writer1.getBook());
        System.out.println("before writer1 book name:" + writer1.getBook().getName());

        System.out.println("before writer2 : " + writer2);
        System.out.println("before writer2 book addr:" + writer2.getBook());
        System.out.println("before writer2 book name:" + writer2.getBook().getName());

        System.out.println("------------");

        writer2.getBook().setName("小小的梦想");
        writer2.getBook().setPage(55);
//        writer2.setBook(book3);


        System.out.println("after writer1 book addr:" + writer1.getBook());
        System.out.println("after writer1 book name:" + writer1.getBook().getName());
        System.out.println("after writer1 book name:" + writer1.getBook().getPage());
        System.out.println("after writer2 book addr:" + writer2.getBook());
        System.out.println("after writer2 book name:" + writer2.getBook().getName());
        System.out.println("after writer1 book name:" + writer2.getBook().getPage());

        // 要实现深拷贝可以通过序列化的方式,
        // 也可以通过克隆的方式,不过在克隆的对象中的引用类型也要进行拷贝(当引用类型很多时,会很笨重).
        // 不过序列化的方式,要比hotSpot虚拟机实现clone()方法要差很多.


    }
}