package practice.Array;

import java.util.ArrayList;

public class Array {

    ArrayList<Integer> list;

    Array filter() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 3) {
                list.remove(i);
                i--;
            }
        }
        return this;
    }

    Array sort() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(i) < list.get(j)) {
                    Integer tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }

        return this;
    }

    @Override
    public String toString() {
        return "Array{" +
                "list=" + list.toString() +
                '}';
    }
}
