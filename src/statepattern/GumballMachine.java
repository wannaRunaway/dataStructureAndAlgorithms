package statepattern;

/*
* 状态机模式
*
* 允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类
*   策略模式和状态模式的类图是一样的，策略使用行为和算法来配置Context类；
*   状态模式允许context随着状态的行为而改变行为
* */
public class GumballMachine {
//    public int SOLD_OUT = 0;
//    public int NO_QUARTER = 1;
//    public int HAS_QUARTER = 2;
//    public int SOLD= 3;
//
//    int state = SOLD_OUT;
//    int count = 0;
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    String location;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(String location , int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        this.location = location;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    public State getState() {
        return state;
    }

    public String getLocation() {
        return location;
    }

    /*
    * 投递25分
    * */
    public void insertQuarter() {
        state.insertQuarter();
    }

    /*
    * 返回25分
    * */
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    /*
    * 旋转曲柄
    * */
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    /*
    * 设置状态
    * */
    void setState(State state) {
        this.state = state;
    }

    /*
    * 产出糖果
    * */
    void releaseBalll() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    /*
    * getter 获取每个对象状态
    * */

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public int getCount() {
        return count;
    }

    public State getWinnerState() {
        return winnerState;
    }

    /*
    * 投递25分
    * */
//    public void insertQuarter() {
//        if (state == HAS_QUARTER) {
//            System.out.println("You can't insert another quarter");
//        } else if (state == NO_QUARTER) {
//            state = HAS_QUARTER;
//            System.out.println("You inserted a quarter");
//        } else if (state == SOLD_OUT) {
//            System.out.println("You can't insert a quarter, the machine is sold out");
//        } else if (state == SOLD) {
//            System.out.println("Please wait, we're already giving you a gumball");
//        }
//    }

    /*
    * 返回25分
    * */
//    public void ejectQuarter() {
//        if (state == HAS_QUARTER) {
//            System.out.println("Quarter returne md");
//            state = NO_QUARTER;
//        } else if (state == NO_QUARTER) {
//            System.out.println("You haven't inserted a quarter");
//        } else if (state == SOLD) {
//            System.out.println("Sorry, you already turned the crank");
//        } else if (state == SOLD_OUT) {
//            System.out.println("You can't eject, you haven't inserted a quarter yet");
//        }
//    }

    /*
    * 顾客转动曲柄
    * */
//    public void turnCrank() {
//        if (state == SOLD) {
//            System.out.println("Turning twice doesn't get you another gumball");
//        } else if (state == NO_QUARTER) {
//            System.out.println("You turned but there's no quarter");
//        } else if (state == SOLD_OUT) {
//            System.out.println("You turned, but there are no gumballs");
//        } else if (state == HAS_QUARTER) {
//            System.out.println("You turned...");
//            state = SOLD;
//            dispense();
//        }
//    }

    /*
    * 发放
    * */
//    public void dispense() {
//        if (state == SOLD) {
//            System.out.println("A gumball comes rolling out the slot");
//            count = count -1;
//            if (count == 0){
//                System.out.println("Oops, out of gumballs");
//                state = SOLD_OUT;
//            } else {
//                state = NO_QUARTER;
//            }
//        } else if (state == NO_QUARTER) {
//            System.out.println("You need to pay first");
//        } else if (state == SOLD_OUT) {
//            System.out.println("No gumball dispensed");
//        } else if (state == HAS_QUARTER) {
//            System.out.println("No gumball dispensed");
//        }
//    }
}
