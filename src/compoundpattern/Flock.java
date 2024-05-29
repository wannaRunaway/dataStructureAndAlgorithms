package compoundpattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 使用组合模式来管理一群鸭子
 * 不需要使用抽象工厂灌流单个的鸭子
 * */
public class Flock implements Quackable{
    ArrayList quackers = new ArrayList();

    public void add(Quackable quackable) {
        quackers.add(quackable);
    }
    @Override
    public void quack() {
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quackable = (Quackable) iterator.next();
            quackable.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
