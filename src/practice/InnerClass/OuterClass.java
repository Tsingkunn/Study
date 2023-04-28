package practice.InnerClass;

public class OuterClass {
    String str = "外部类的成员变量...";

    public OuterClass() {
        System.out.println("外部类的构造方法...");
    }

    public void run() {
        String str = "局部变量";
        class Inner {
            public Inner() {

            }

            void done() {
                System.out.println(OuterClass.this.str);

                System.out.println();
                System.out.println(str);
            }
        }

    }

}
