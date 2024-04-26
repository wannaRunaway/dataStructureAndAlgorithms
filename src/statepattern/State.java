package statepattern;

/*
* 状态接口
* */
public interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();

    /*
    * 状态
    * */
    public int soldOutState = 0;
    public int noQuarterState = 1;
    public int hasQuarterState = 2;
    public int soldState = 3;
}
