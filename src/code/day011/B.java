package code.day011;

@FunctionalInterface
public interface B {
    void funB();

    default void funC() {
    }

}
