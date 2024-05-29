package compoundpattern;

public class Driver {

    /** 绿头鸭 */
    public static class MallardDuck implements Quackable {
        @Override
        public void quack() {
            System.out.println("Quack");
        }

        @Override
        public void registerObserver(Observer observer) {

        }

        @Override
        public void notifyObservers() {

        }
    }

    /** 红头鸭 */
    public static class RedheadDuck implements Quackable {
        @Override
        public void quack() {
            System.out.println("Quack");
        }

        @Override
        public void registerObserver(Observer observer) {

        }

        @Override
        public void notifyObservers() {

        }
    }

    /** duckcall */
    public static class DuckCall implements Quackable {
        @Override
        public void quack() {
            System.out.println("Kwak");
        }

        @Override
        public void registerObserver(Observer observer) {

        }

        @Override
        public void notifyObservers() {

        }
    }

    /** 橡皮鸭子 */
    public static class RubberDuck implements Quackable {
        @Override
        public void quack() {
            System.out.println("Squeak");
        }

        @Override
        public void registerObserver(Observer observer) {

        }

        @Override
        public void notifyObservers() {

        }
    }

    /** duck分析类 */
    public static class DuckSimulator {
        public static void main(String[] args) {
            DuckSimulator duckSimulator = new DuckSimulator();
            AbstractDuckFactory duckFactory = new CountingDuckFactory();
            duckSimulator.simulate(duckFactory);
        }

        private void simulate(AbstractDuckFactory duckFactory) {
//            Quackable mallardDuck = duckFactory.createMallardDuck();
            Quackable redheadDuck = duckFactory.createRedheadDuck();
            Quackable duckCall = duckFactory.createDuckCall();
            Quackable rubberDuck = duckFactory.createRubberDuck();
            Quackable gooseDuck = new GooseAdapter(new Goose());
            System.out.println("\nDuck Simulator: With Abstract Factory");

            Flock flockDucks = new Flock();
            flockDucks.add(redheadDuck);
            flockDucks.add(duckCall);
            flockDucks.add(rubberDuck);
            flockDucks.add(gooseDuck);

            Flock flockOfMallards = new Flock();
            Quackable mallardOne = duckFactory.createMallardDuck();
            Quackable mallardTwo = duckFactory.createMallardDuck();
            Quackable mallardThree = duckFactory.createMallardDuck();
            Quackable mallardFour = duckFactory.createMallardDuck();
            flockOfMallards.add(mallardOne);
            flockOfMallards.add(mallardTwo);
            flockOfMallards.add(mallardThree);
            flockOfMallards.add(mallardFour);

            Flock flockOfDucks = new Flock();
            Quackable mallardQuack = new compoundpattern.MallardDuck();
            flockOfDucks.add(mallardQuack);

            flockDucks.add(flockOfMallards);
            System.out.println("\nDuck simulator: Whole Flock Simulator");
            simulate(flockDucks);

            System.out.println("\nDuck simulator: Mallard Flock Simulator");
            simulate(flockOfMallards);

//            simulate(mallardDuck);
//            simulate(redheadDuck);
//            simulate(duckCall);
//            simulate(rubberDuck);
//            simulate(gooseDuck);

            System.out.println("\nDuck Simulator: With Observer");
            Quackologist quackologist = new Quackologist();
            flockOfDucks.registerObserver(quackologist);
            simulate(flockDucks);

            System.out.println("The ducks quacks "+ QuackCounter.getQuacks()+ " times");
        }

        void simulate(Quackable duck) {
            duck.quack();
        }

        private void simulate() {
            Quackable mallardDuck = new QuackCounter(new MallardDuck());
            Quackable redheadDuck = new QuackCounter(new RedheadDuck());
            Quackable duckCall = new QuackCounter(new DuckCall());
            Quackable rubberDuck = new QuackCounter(new RubberDuck());
            Quackable gooseDuck = new GooseAdapter(new Goose());
            System.out.println("\nDuck Simulator");

            simulate(mallardDuck);
            simulate(redheadDuck);
            simulate(duckCall);
            simulate(rubberDuck);
            simulate(gooseDuck);

            System.out.println("The ducks quacked "+ QuackCounter.getQuacks()+" times");
        }
    }

    /** 大鹅 */
    public static class Goose {
        public void honk() {
            System.out.println("Honk");
        }
    }

    /** 大鹅适配器 */
    public static class GooseAdapter implements Quackable{
        Goose goose;
        public GooseAdapter(Goose goose) {
            this.goose = goose;
        }
        @Override
        public void quack() {
            goose.honk();
        }

        @Override
        public void registerObserver(Observer observer) {

        }

        @Override
        public void notifyObservers() {

        }
    }

    /** 需要计算鸭子叫的次数 */
    public static class QuackCounter implements Quackable {
        Quackable duck;
        static int numberOfQuacks;

        public QuackCounter(Quackable duck) {
            this.duck = duck;
        }
        @Override
        public void quack() {
            duck.quack();
            numberOfQuacks++;
        }
        public static int getQuacks() {
            return numberOfQuacks;
        }

        @Override
        public void registerObserver(Observer observer) {

        }

        @Override
        public void notifyObservers() {

        }
    }

}
