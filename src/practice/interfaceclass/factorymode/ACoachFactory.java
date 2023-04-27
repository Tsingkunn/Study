package practice.interfaceclass.factorymode;

public class ACoachFactory implements CoachFactory {
    @Override
    public Coach createCoach() {
        return new ACoach();
    }
}
