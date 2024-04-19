package iteratorsandcombination;

import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenu{
    Hashtable menuItems = new Hashtable();

    public CafeMenu() {
        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99);
        addItem("Soup of the day",
                "A cup of the soup of the day, with  a side salad",
                false, 3.69);
        addItem("Burrito",
                "A larger burrito, with whole pinto beans, salsa, quacamole",
                true, 4.29);
    }

    public void addItem(String name, String decription,
                        boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, decription, vegetarian, price);
        menuItems.put(menuItem.getName(), menuItem);
    }

    private Hashtable getItems() {
        return menuItems;
    }

//    @Override
//    public Iterator createIterator() {
//        return menuItems.values().iterator();
//    }
}
