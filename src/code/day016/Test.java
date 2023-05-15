package code.day016;

import code.day016.factory.CatFactory;

public class Test {
    public static void main(String[] args) {
        var cat = new CatFactory().getInstance();

        cat.eat();
    }
}
