public class Single02 {

    private static Single02 instance;

    private Single02() {
    }

    public synchronized Single02 getInstance() {
        if (instance == null) {
            instance = new Single02();
        }
        return instance;
    }

}
