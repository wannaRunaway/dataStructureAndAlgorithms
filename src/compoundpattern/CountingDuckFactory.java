package compoundpattern;

/**
 * 用来计数的鸭子工厂
 * */
public class CountingDuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createMallardDuck() {
        return new Driver.QuackCounter(new Driver.MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new Driver.QuackCounter(new Driver.RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new Driver.QuackCounter(new Driver.DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new Driver.QuackCounter(new Driver.RubberDuck());
    }
}
