package templatemethodpattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 模版方法模式
 *
 * 在一个方法中定义一个算法的骨架，将一些步骤延迟到子类中；
 * 模版方法模式可以在不改变算法结构的情况下，重新定义算法中的某些步骤。
 *
 * 注意：策略模式和模版方法模式有点相似，区别在于：
 * 策略模式和模版方法模式都封装算法，但策略使用组合，模版方法使用继承
 * 工厂方法是模版方法的一个特殊版本
 *
 * */
public class TemplateMethodPattern {
    static class Coffee extends CaffeineBeverageWithHook {
        @Override
        void brew() {
            System.out.println("Dripping coffee through filter");
        }

        @Override
        void addCondiments() {
            System.out.println("Adding Sugar and Milk");
        }
    }

    /* 咖啡制作过程 */
    /* 茶制作过程 */
    static class Tea extends CaffeineBeverageWithHook {
        @Override
        void brew() {
            System.out.println("Steeping the tea");
        }

        @Override
        void addCondiments() {
            System.out.println("Adding Lemon");
        }
    }

    static abstract class CaffeineBeverageWithHook {
        final void prepareRecipe() {
            boilWater();
            brew();
            pourInCup();
            if (customerWantsCondiments()) {
                addCondiments();
            }
        }

        abstract void brew();

        abstract void addCondiments();

        void boilWater() {
            System.out.println("Boiling water");
        }

        void pourInCup() {
            System.out.println("Pouring into cup");
        }

        boolean customerWantsCondiments() {
            return true;
        }
    }
    static class CoffeeWithHook extends CaffeineBeverageWithHook {

        @Override
        void brew() {
            System.out.println("Dripping Coffee through filter");
        }

        @Override
        void addCondiments() {
            System.out.println("Adding Sugar and Milk");
        }
        public boolean customerWantsCondiments() {
            String answer = getUserInput();
            if (answer.toLowerCase().startsWith("y")){
                return true;
            } else return false;
        }

        private String getUserInput() {
            String answer = null;
            System.out.print("Would u like milk and sugar with your coffee(y/n)?");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {
                answer = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (answer == null) {
                return "no";
            }
            return answer;
        }
    }

    public static void main(String[] args) {
//        Tea myTea = new Tea();
//        myTea.prepareRecipe();
        CoffeeWithHook coffeeWithHook
                 = new CoffeeWithHook();
        System.out.println("\n Making coffee...");
        coffeeWithHook.prepareRecipe();
    }
}
