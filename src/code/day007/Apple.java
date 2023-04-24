package code.day007;

import practice.features.internal.run.App;

public class Apple {
    int i = 0;

    Apple eatApple() {
        i++;
        return this;
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.eatApple().eatApple().eatApple().eatApple().eatApple().eatApple().eatApple().eatApple();
        System.out.println("吃了 " + apple.i + "次苹果");
    }
}
