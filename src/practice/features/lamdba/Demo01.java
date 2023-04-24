package practice.features.lamdba;

public class Demo01 {
    public static void main(String[] args) {
        // lambda的格式 (参数)->{方法体}
        // 可以使用lambda简化的情形情形
        // 匿名内部类是一个接口,且匿名内部类中只有一个""抽象方法"".
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类的方法被执行了!");
            }
        }).start();

        // lambda,不关注类名和方法名,只关注参数和方法体;
        new Thread(() -> System.out.println("Lambda方法被执行了!")).start();
    }

}
