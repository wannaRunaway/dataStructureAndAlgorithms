package iteratorsandcombination;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 使用arraylist存储menu
 * */
public class PancakeHouseMenu{
    ArrayList menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList();

        addItems("KB's Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast",
                true,
                2.99);

        addItems("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99);

        addItems("Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true,
                3.49);

        addItems("Waffles",
                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59);
    }

    public void addItems(String name, String description,
                         boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

//    @Override
//    public Iterator createIterator() {
//        return menuItems.iterator();
//    }

//    public ArrayList getMenuItems() {
//        return menuItems;
//    }

    /*
    * 不使用自己的迭代器，而是使用arraylist的iterator()方法
    * */
//    public Iterator createIterator() {
//        return menuItems.iterator();
//    }

    //其他更多实现的代码
}
