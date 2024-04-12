package decoratorpattern;

/*
 * 装饰者模式:动态的将责任附加到对象上，对扩展开放，对修改关闭
 * 除了继承，装饰着模式也可以让我们扩展行为，会有一群装饰着类
 * 装饰者会让程序出现很多小对象，对于不了解的人说很麻烦
 *
 * 装饰类、被装饰类来自同一个超类
 *
 * */
public class DecoratorPattern {


    public abstract static class Beverage {
        String description = "Unknow Beverage";

        public String getDescription() {
            return description;
        }

        public abstract double cost();
    }

    /* 调料 */
    public abstract static class CondimentDecorator extends Beverage {
        public abstract String getDescription();
    }

    /* 饮料 */
    public static class Espresso extends Beverage {
        public Espresso() {
            description = "Espresso";
        }

        @Override
        public double cost() {
            return 1.99;
        }
    }

    public static class HouseBlend extends Beverage {
        public HouseBlend() {
            description = "House Blend Coffee";
        }

        @Override
        public double cost() {
            return 0.89;
        }
    }

    /* 调料 */
    public static class Mocha extends CondimentDecorator {
        Beverage beverage;

        public Mocha(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ", Mocha";
        }

        @Override
        public double cost() {
            return 0.2 + beverage.cost();
        }
    }

    public static class Soy extends CondimentDecorator {
        Beverage beverage;

        public Soy(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ", Soy";
        }

        @Override
        public double cost() {
            return 0.4 + beverage.cost();
        }
    }

    public static class Whip extends CondimentDecorator {
        Beverage beverage;

        public Whip(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ", Whip";
        }

        @Override
        public double cost() {
            return 0.33 + beverage.cost();
        }
    }

    public static void main(String[] args) {
        /* 订一杯Espresso 不需要调料 */
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $ "
                + beverage.cost());

        /*
         * HouseBlend() 使用调料装饰
         * */
        Beverage houseBlend = new HouseBlend();
        houseBlend = new Soy(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Whip(houseBlend);
        System.out.println(houseBlend.getDescription() + " $ " + houseBlend.cost());

    }
}
