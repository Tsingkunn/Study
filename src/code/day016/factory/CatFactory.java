package code.day016.factory;

public class CatFactory implements EntityFactory {

    @Override
    public Animal getInstance() {
        return new Cat();
    }

}
