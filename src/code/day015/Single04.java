public class Single04 {
    private static class SingleHolder {
        private static final Single04 INSTANCE = new Single04();
    }

    private Single04() {
    }

    public Single04 getInstance() {
        return SingleHolder.INSTANCE;
    }
}
