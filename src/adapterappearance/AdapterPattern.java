package adapterappearance;

/*
 * 适配器模式
 *
 * 外观模式不用写了，很简单的模式，将复杂的接口使用外观简化，注意不改变原来接口，只简化接口
 * 容易混淆的三个设计模式：
 *  1、适配器模式：将对象包装起来改变起接口，适配调用方
 *  2、装饰者模式：装饰类和被装饰类来自同一超类，将对象包装起来增加新的行为和责任
 *  3、外观模式：将一群对象包装起来，简化其接口
 * */
public class AdapterPattern {

    public interface Duck {
        void quack();

        void fly();
    }

    /* 绿头鸭 */
    static class MallardDuck implements Duck {
        @Override
        public void quack() {
            System.out.println("Quack");
        }

        @Override
        public void fly() {
            System.out.println("I am flying");
        }
    }

    /* 火鸡 */
    public interface Turkey {
        void gobble();

        void fly();
    }

    static class WildTurkey implements Turkey {
        @Override
        public void gobble() {
            System.out.println("Gobble gobble");
        }

        @Override
        public void fly() {
            System.out.println("I am flying a short distance");
        }
    }

    static class TurkeyAdapter implements Duck {
        Turkey turkey;

        public TurkeyAdapter(Turkey turkey) {
            this.turkey = turkey;
        }

        @Override
        public void quack() {
            turkey.gobble();
        }

        @Override
        public void fly() {
            for (int i = 0; i < 7; i++) {
                turkey.fly();
            }
        }
    }

    public static void main(String[] args) {
        /* 鸭子 */
        MallardDuck duck = new MallardDuck();
        /* 火鸡 */
        WildTurkey turkey = new WildTurkey();
        /* 火鸡包装进适配器，让他像是鸭子 */
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\n The Duck says...");
        duck.quack();
        duck.fly();

        System.out.println("\n The TurkeyAdapter says...");
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}
