package statepattern;

import proxypattern.GumballMonitor;

public class GumballMachineTestDrive {
    public static void main(String[] args) {

        GumballMachine gumballMachine = new GumballMachine("location",5);
        System.out.println(gumballMachine);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);

//        int count = 0;
//        if (args.length < 2) {
//            System.out.println("GumballMachine <name> <inventory>");
//            System.exit(1);
//        }
//
//        count = Integer.parseInt(args[1]);
//        GumballMachine gumballMachine1 = new GumballMachine(args[0], count);
//        GumballMonitor monitor = new GumballMonitor(gumballMachine1);
//
//        monitor.report();

//        GumballMachine gumballMachine = new GumballMachine(5);
//        System.out.println(gumballMachine);
//
//        gumballMachine.insertQuarter();
//        gumballMachine.turnCrank();
//        System.out.println(gumballMachine);
//
//        gumballMachine.insertQuarter();
//        gumballMachine.ejectQuarter();
//        gumballMachine.turnCrank();
//        System.out.println(gumballMachine);
//
//        gumballMachine.insertQuarter();
//        gumballMachine.turnCrank();
//        gumballMachine.insertQuarter();
//        gumballMachine.turnCrank();
//        gumballMachine.ejectQuarter();
//        System.out.println(gumballMachine);
//
//        gumballMachine.insertQuarter();
//        gumballMachine.insertQuarter();
//        gumballMachine.turnCrank();
//        gumballMachine.insertQuarter();
//        gumballMachine.turnCrank();
//        gumballMachine.insertQuarter();
//        gumballMachine.turnCrank();
//        System.out.println(gumballMachine);
    }
}
