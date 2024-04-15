package factorypattern;

import java.util.ArrayList;

/*
 * 工厂模式
 * */
public class FactoryPattern {
    /*
     * 抽象pizza商店
     * */
    public static abstract class PizzaStore {
        abstract Pizza createPizza(String type);

        public Pizza orderPizza(String type) {
            Pizza pizza;
            pizza = createPizza(type);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.boz();
            return pizza;
        }
    }

    static abstract class Pizza {
        String name;
        Dough dough;
        Sauce sauce;
        Cheese cheese;
        ArrayList toppings = new ArrayList();

        /* prepare()变为抽象方法 */
        abstract void prepare();

//        private void prepare() {
//            System.out.println("Preparing " + name);
//            System.out.println("Tossing dough...");
//            System.out.println("adding sauce...");
//            System.out.println("Adding toppings: ");
//            for (int i = 0; i < toppings.size(); i++) {
//                System.out.println("    " + toppings.get(i));
//            }
//        }

        void bake() {
            System.out.println("Bake for 25 minutes at 350");
        }

        void cut() {
            System.out.println("Cutting the pizza into diagonal slices");
        }

        private void boz() {
            System.out.println("Place pizza in official PizzaStore box");
        }

        public String getName() {
            return name;
        }
    }

    static class NYCheesePizza extends Pizza {
        PizzaIngredientFactory ingredientFactory;

        public NYCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
            this.ingredientFactory = pizzaIngredientFactory;
        }

        @Override
        void prepare() {
            System.out.println("preparing " + name);
            dough = ingredientFactory.createDough();
            sauce = ingredientFactory.createSauce();
            cheese = ingredientFactory.createCheese();
        }

    }

    static class BuffloPizza extends Pizza {
        PizzaIngredientFactory pizzaIngredientFactory;

        public BuffloPizza(PizzaIngredientFactory pizzaIngredientFactory) {
            this.pizzaIngredientFactory = pizzaIngredientFactory;
        }

        @Override
        void prepare() {
            System.out.println("preparing " + name);
            dough = pizzaIngredientFactory.createDough();
            sauce = pizzaIngredientFactory.createSauce();
            cheese = pizzaIngredientFactory.createCheese();
        }

        @Override
        void cut() {
            System.out.println("Cutting the pizza into square slices");
        }
    }

    static class NYPizzaStore extends PizzaStore {
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        @Override
        Pizza createPizza(String type) {
            if (type.equals("cheese")) {
                return new NYCheesePizza(ingredientFactory);
            } else {
                return null;
            }
        }
    }

    static class BuffloPizzaStore extends PizzaStore {
        /* 使用同一种原料工厂， 来自NY原料工厂 */
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        @Override
        Pizza createPizza(String type) {
            if (type.equals("bufflo")) {
                return new BuffloPizza(ingredientFactory);
            } else return null;
        }
    }

    public static void main(String[] args) {
        /* 创建ny pizza 商店 */
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore buffPizzaStore = new BuffloPizzaStore();

        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Ethan orderrd a " + pizza.getName() + "\n");

        pizza = buffPizzaStore.orderPizza("bufflo");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }

    public interface PizzaIngredientFactory {
        public Dough createDough();

        public Sauce createSauce();

        public Cheese createCheese();
    }

    static class Dough {
    }

    static class ThinCrustDough extends Dough {
    }

    static class Sauce {
    }

    static class MarinaraSauce extends Sauce {
    }

    static class Cheese {
    }

    static class ReggianoCheese extends Cheese {
    }

    static class NYPizzaIngredientFactory implements PizzaIngredientFactory {
        @Override
        public Dough createDough() {
            return new ThinCrustDough();
        }

        @Override
        public Sauce createSauce() {
            return new MarinaraSauce();
        }

        @Override
        public Cheese createCheese() {
            return new ReggianoCheese();
        }
    }

}


