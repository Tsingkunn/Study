package practice.interfaceclass.adaptermode;

// 抽象类实现接口,并放置空方法
abstract class AdapterCoach implements Coach {
    @Override
    public void defend() {
    }

    @Override
    public void attack() {
    }
}
