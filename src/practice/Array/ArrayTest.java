package practice.Array;

import java.util.ArrayList;

public class ArrayTest {

    public static void main(String[] args) {
        Array array = new Array();
        array.list = new ArrayList<>();
        array.list.add(-1);
        array.list.add(-1);
        array.list.add(-3);
        array.list.add(1);
        array.list.add(5);
        array.list.add(4);
        array.list.add(-7);
        array.list.add(8);
        array.list.add(-5);
        array.list.add(9);
        // >> -1,-1,-3,1,5,4,-7,8,-5,9
//        System.out.println(array.filter().sort().toString());
        // >>Array{list=[4, 5, 8, 9]}
    }

}
