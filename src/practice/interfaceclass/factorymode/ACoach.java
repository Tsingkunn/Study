package practice.interfaceclass.factorymode;

public class ACoach implements Coach {
    @Override
    public void command() {
        System.out.println("A级教练.");
    }
}
