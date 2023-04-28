package practice.features.lamdba;

@FunctionalInterface
public interface ArrayInterface<T, R> {
    Boolean isLengthEquals(T[] arr, R[] anotherArr);
}
