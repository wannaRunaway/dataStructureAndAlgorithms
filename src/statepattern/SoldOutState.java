package statepattern;

/*
 * 糖果售罄状态
 * */
public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("take back you money! Sorry, no candies");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("no quarter inside, and no candies");
    }

    @Override
    public void turnCrank() {
        System.out.println("no candies inside, turnCrank is useless");
    }

    @Override
    public void dispense() {
        System.out.println("sorry Machine is soldOut");
    }
}
