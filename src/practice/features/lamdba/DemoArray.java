package practice.features.lamdba;

import code.day008.bookmanager.entity.Book;

import java.util.function.Supplier;

public class DemoArray {
    public static void main(String[] args) {
        new Supplier<String>() {

            @Override
            public String get() {
                return null;
            }
        };


        String[] arrStr = {"青君", "哥哥", "太帅啦", "!"};
        Integer[] arrNum = {1, 2, 3, 4};

        boolean b1 = isEqualsLength(new ArrayInterface<String, Integer>() {
            @Override
            public Boolean isLengthEquals(String[] arr, Integer[] anotherArr) {
                return arr.length == anotherArr.length;
            }
        }, arrStr, arrNum);

        boolean b2 = isEqualsLength((arr, anotherArr) -> arr.length == anotherArr.length, arrStr, arrNum);


        boolean b3 = new ArrayInterface<String, Integer>() {
            @Override
            public Boolean isLengthEquals(String[] arr, Integer[] anotherArr) {
                return arr.length == anotherArr.length;
            }
        }.isLengthEquals(arrStr, arrNum);


        boolean b4 = ((ArrayInterface<String, Integer>) (arr, anotherArr) -> arr.length == anotherArr.length).isLengthEquals(arrStr, arrNum);

    }

    public static boolean isEqualsLength(ArrayInterface<String, Integer> arrayInterface, String[] arr, Integer[] anotherArr) {
        return arrayInterface.isLengthEquals(arr, anotherArr);
    }
}
