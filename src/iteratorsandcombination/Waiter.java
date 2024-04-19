package iteratorsandcombination;

import java.util.ArrayList;
import java.util.Iterator;
/*
* 迭代器模式：提供一种方法顺序访问一个聚合对象中的各个元素，而不暴露内部的表示
*
* 游走于聚合内的每一个元素不会暴露内部的表示，简化了聚合的接口和实现，让责任各得其所
* */
public class Waiter {
    Menu pancakeHouseMenu;
    Menu dinerMenu;
    Menu cafeMenu;
    ArrayList menus;
    MenuComponent allMenus;

    public Waiter(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public Waiter(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
    }

    public Waiter(ArrayList menus) {
        this.menus = menus;
    }

    public void printMenu() {
        allMenus.print();
    }

    public void printVegetarianMenu() {
//        Iterator iterator = allMenus.
    }

//    public void printMenu() {
//        Iterator iterator = menus.iterator();
//        while (iterator.hasNext()) {
//            Menu menu = (Menu) iterator.next();
//            printMenu(menu.createIterator());
//        }
//    }

//    public void printMenu() {
//        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
//        Iterator dinnerIterator = dinerMenu.createIterator();
//        Iterator cafeIterator = cafeMenu.createIterator();
//        System.out.println("MENU\n-----\nBREAKFAST");
//        printMenu(pancakeIterator);
//        System.out.println("\nLUNCH");
//        printMenu(dinnerIterator);
//        System.out.println("\nDINNER");
//        printMenu(cafeIterator);
//    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName()+"  "+menuItem.getDescription()+"  "+
                    menuItem.getPrice());
        }
    }
}
