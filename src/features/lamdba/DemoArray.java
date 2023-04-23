package features.lamdba;

public class DemoArray {
    public static void main(String[] args) {

        boolean b1 = isEqualsLength(new Array() {
            // 自己定义的泛型接口方法,在调用时,要制定具体的引用类型(基本类型时不可以的)
            @Override
            public Boolean isLengthEquals(String[] arr, Integer[] anotherArr) {
                return arr.length == anotherArr.length;
            }
        });

        System.out.println(b1);

        boolean b2 = isEqualsLength((arrStr, arrNum) -> {
            return arrStr.length == arrNum.length;
        });
        System.out.println(b2);
    }

    public static <T, R> boolean isEqualsLength(Array<T, R> array) {
        String[] arrStr = {"青君", "哥哥", "太帅啦", "!"};
        Integer[] arrNum = {1, 2, 3, 4};
        return array.isLengthEquals(arrStr, arrNum);
    }
}
