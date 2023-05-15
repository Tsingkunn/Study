
/**
 * 懒汉式
 */
public class Single {
    private static Single instance;

    private Single() {
    }

    public static synchronized Single getInstance() {
        if (instance == null) {
            instance = new Single();
        }
        return instance;
    }
}
