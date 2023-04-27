package practice.interfaceclass.adaptermode;

/**
 * 如果我们只需要对接口中其中一个方法进行实现的话,可以使用一个抽象类作为中间插件,即适配器;
 * 用适配器抽象类去实现接口,并置空方法,这时候心类就可以绕过接口,实现抽象类,只对需要的方法进行覆盖,
 * 而不是接口中的所有方法
 */
public class Demo {
    public static void main(String[] args) {
        Coach coach = new Hesai();
        coach.defend();
    }
}
