package iteratorsandcombination;

public class MenuTestDrive {
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waiter waiter = new Waiter(pancakeHouseMenu, dinerMenu);
        waiter.printMenu();
    }
}
