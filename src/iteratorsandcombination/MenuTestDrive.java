package iteratorsandcombination;

/*
* 单一责任，一个类应该只有一个引起变化的原因
* */
public class MenuTestDrive {
    public static void main(String[] args) {
//        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
//        DinerMenu dinerMenu = new DinerMenu();
//        CafeMenu cafeMenu = new CafeMenu();
//
//        Waiter waiter = new Waiter(pancakeHouseMenu, dinerMenu, cafeMenu);
//        waiter.printMenu();

        MenuComponent pancakeHouseMenu =
                new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu =
                new Menu("DINER MENU", "LUNCH");
        MenuComponent cafeMenu =
                new Menu("CAFE MENU", "Dinner");
        MenuComponent dessertMenu =
                new Menu("DESSERT MENU", "Dessert of course");
        MenuComponent allMenus = new Menu("ALL MENUS", "ALL menus combined");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        /* 加入菜单项 */
        dinerMenu.add(new MenuItem("Pasta",
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                true, 3.89));
        dinerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem("Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla ice cream",
                true, 1.59));

        Waiter waiter = new Waiter(allMenus);
        waiter.printMenu();
    }
}
