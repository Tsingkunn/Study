package code.day007;

public class Test03 {
    // 静态属性
    private static final String staticField = getStaticField();

    // 静态块
    static {
        System.out.println(staticField);
        System.out.println("静态方法块初始化");
    }

    // 普通属性
    private final String field = getField();

    // 普通方法快
    {
        System.out.println(field);
    }

    // 构造函数
    public Test03() {
        System.out.println("构造函数初始化");
    }

    public static String getStaticField() {
        return "Static Field Initial";
    }

    public static String getField() {
        return "Field Initial";
    }

    // 主函数
    public static void main(String[] argc) {
        new Test03();
    }
}