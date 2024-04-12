/*
*   经典的鸭子叫、鸭子飞 问题
*   呦吼、原来这是个策略模式
* 策略模式定义了算法族，分别封装了起来，让他们可以互相替换，让算法的变化独立于使用算法的客户
* */

public class Duck {

    /* 飞行behavior */
    public interface FlyBehavior {
        public void fly();
    }
    /* 飞行类 */
    public static class FlyWithWings implements FlyBehavior {

        @Override
        public void fly() {
            System.out.println("I am flying");
        }
    }
    /* 不会飞行类 */
    public static class FlyNoWay implements FlyBehavior {

        @Override
        public void fly() {
            System.out.println("I cant fly");
        }
    }

    /* 叫声behavior */
    public interface QuackBehavior {
        public void quack();
    }
    public static class Quack implements QuackBehavior {

        @Override
        public void quack() {
            System.out.println("Quack");
        }
    }
    public class MuteQuack implements QuackBehavior {

        @Override
        public void quack() {
            System.out.println("<< Silence >>");
        }
    }
    public class Squeak implements QuackBehavior {

        @Override
        public void quack() {
            System.out.println("Squeak");
        }
    }

    public abstract static class MineDuck {

        FlyBehavior flyBehavior;
        QuackBehavior quackBehavior;
        public MineDuck() {}
        /* 每只鸭子都有不同的外观 */
        public abstract void display();
        public void performFly() {
            flyBehavior.fly();
        }
        public void performQuack() {
            quackBehavior.quack();
        }
        /* 每只鸭子都会游泳 */
        public void swim() {
            System.out.println("All ducks float, even decoys");
        }
        /* 动态设定行为 */
        public void setFlyBehavior(FlyBehavior fb) {
            flyBehavior = fb;
        }
        public void setQuackBehavior(QuackBehavior qb) {
            quackBehavior = qb;
        }
    }
    public static class MallardDuck extends MineDuck {
        public MallardDuck() {
            quackBehavior = new Quack();
            flyBehavior = new FlyWithWings();
        }
        @Override
        public void display() {
            System.out.println("MallardDuck.display");
        }
    }
    /* 火箭模型鸭 */
    public static class ModelDuck extends MineDuck {
        public ModelDuck() {
            flyBehavior = new FlyNoWay();
            quackBehavior = new Quack();
        }
        @Override
        public void display() {
            System.out.println("I am a model duck");
        }
    }
    /* 火箭behavior */
    public static class FlyRocketPowered implements FlyBehavior {

        @Override
        public void fly() {
            System.out.println("I am flying with a rocket");
        }
    }

//    class Test {
        public static void main(String[] args) {
            MineDuck mallard = new MallardDuck();
            mallard.performQuack();
            mallard.performFly();

            MineDuck modelDuck = new ModelDuck();
            modelDuck.performFly();
            modelDuck.setFlyBehavior(new FlyRocketPowered());
            modelDuck.performFly();
        }
//    }



}
