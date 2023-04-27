package practice.interfaceclass.factorymode;

public class CCoach implements Coach {
    @Override
    public void command() {
        System.out.println("C级教练");
    }
}
