package code.day008.test;

public class Test {
    Insect ant = new Ant();
    Bird geese = new Geese();
    Bird pigeon = new Pigeon();
    Insect bee = new Bee();

    public static void main(String[] args) {
        Test test = new Test();

        test.ant.fly();
        test.bee.spawning();
        System.out.println(test.geese.leg);
    }
}
