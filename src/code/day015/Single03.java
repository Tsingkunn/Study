public class Single03 {
    private volatile static Single03 instance;

    private Single03() {
    }

    public Single03 getInstance() {
        if (instance == null) {
            synchronized (Single03.class) {
                if (instance == null) {
                    instance = new Single03();
                }
            }
        }
        return instance;
    }
}
