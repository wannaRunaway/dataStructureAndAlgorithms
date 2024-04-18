package iteratorsandcombination;

import java.util.Iterator;
/*
* 迭代器模式：提供一种方法顺序访问一个聚合对象中的各个元素，而不暴露内部的表示
*
* 游走于聚合内的每一个元素不会暴露内部的表示，简化了聚合的接口和实现，让责任各得其所
* */
public class Waiter {
    Menu pancakeHouseMenu;
    Menu dinerMenu;

    public Waiter(Menu pancakeHouseMenu, Menu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinnerIterator = dinerMenu.createIterator();
        System.out.println("MENU\n-----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinnerIterator);
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName()+"  "+menuItem.getDescription()+"  "+
                    menuItem.getPrice());
        }
    }
}
