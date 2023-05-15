public enum EnumSingleton {
    INSTANCE;

    public EnumSingleton getInstance() {
        return EnumSingleton.INSTANCE;
    }
}