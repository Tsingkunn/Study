package practice.interfaceclass.factorymode;

public class Demo {

    public static void create(CoachFactory factory) {
        factory.createCoach().command();
    }

    public static void main(String[] args) {
        create(new ACoachFactory());
        create(new CCoachFactory());
    }
}
