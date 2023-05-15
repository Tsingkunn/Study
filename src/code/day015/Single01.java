
/**
 * 饿汉式单例模式
 */
public class Single01 {
    private static final Single01 instance = new Single01();

    private Single01() {
    }

    public static Single01 getInstance() {
        return instance;
    }
}
