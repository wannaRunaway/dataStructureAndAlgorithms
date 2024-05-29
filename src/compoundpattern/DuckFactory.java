package compoundpattern;

/**
 * 单个鸭子工厂
 * */
public class DuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createMallardDuck() {
        return new Driver.MallardDuck();
    }

    @Override
    public Quackable createRedheadDuck() {
        return new Driver.RedheadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new Driver.DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new Driver.RubberDuck();
    }
}
