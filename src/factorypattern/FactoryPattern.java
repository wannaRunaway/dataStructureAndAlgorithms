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
        String dough;
        String sauce;
        ArrayList toppings = new ArrayList();

        private void prepare() {
            System.out.println("Preparing " + name);
            System.out.println("Tossing dough...");
            System.out.println("adding sauce...");
            System.out.println("Adding toppings: ");
            for (int i = 0; i < toppings.size(); i++) {
                System.out.println("    " + toppings.get(i));
            }
        }

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
        public NYCheesePizza() {
            name = "NY Style Sauce and Cheese Pizza";
            dough = "Thin Crust Dough";
            sauce = "Marinara Sauce";
            toppings.add("Grated Reggiano Cheese");
        }
    }

    static class BuffloPizza extends Pizza {
        public BuffloPizza() {
            name = "Bufflo Style Deep Dish Cheesh Pizza";
            dough = "Extra Thick Crust Dough";
            sauce = "Plum Tomato Sauce";
            toppings.add("Shredded Mozzarella Cheese");
        }

        @Override
        void cut() {
            System.out.println("Cutting the pizza into square slices");
        }
    }

    static class NYPizzaStore extends PizzaStore {

        @Override
        Pizza createPizza(String type) {
            if (type.equals("cheese")) {
                return new NYCheesePizza();
            } else {
                return null;
            }
        }
    }

    static class BuffloPizzaStore extends PizzaStore {
        @Override
        Pizza createPizza(String type) {
            if (type.equals("bufflo")) {
                return new BuffloPizza();
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
        System.out.println("Joel ordered a "+ pizza.getName() + "\n");
    }

    public interface PizzaIngredientFactory {
        public Dough createDough();
        public Sauce createSauce();
        public Cheese createCheese;
    }
}


