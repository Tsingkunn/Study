package practice.interfaceclass.factorymode;

public class CCoachFactory implements CoachFactory {
    @Override
    public Coach createCoach() {
        return new Coach() {
            @Override
            public void command() {
                System.out.println("C级教练/./.");
            }
        };
    }
}
