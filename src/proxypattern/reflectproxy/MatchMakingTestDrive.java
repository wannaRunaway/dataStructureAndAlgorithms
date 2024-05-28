package proxypattern.reflectproxy;

public class MatchMakingTestDrive {
    public static void main(String[] args) {
        MatchMakingTestDrive testDrive = new MatchMakingTestDrive();
        testDrive.drive();
    }

    private void drive() {
        PersonBean joePersonBean = new PersonBeanImpl();
        joePersonBean.setName("Joe JavaBean");
        joePersonBean.setGender("man");
        joePersonBean.setHotOrNotRating(1);
        joePersonBean.setInterests("hang out");

        Proxy proxy = new Proxy();
        PersonBean ownerProxy = proxy.getOwnerProxy(joePersonBean);
        System.out.println("Name is "+ ownerProxy.getName());
        ownerProxy.setInterests("bowing, Go");
        System.out.println("Interests set from owner proxy");
        try {
            ownerProxy.setHotOrNotRating(10);
        }catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating()+"\n");

        PersonBean nonOwnerProxy = proxy.getNonOwnerProxy(joePersonBean);
        System.out.println("Name is "+ nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("bowling, Go");
        } catch (Exception e) {
            System.out.println("Can't set interesting from non owner proxy");
        }
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is "+ nonOwnerProxy.getHotOrNotRating());
    }

    public MatchMakingTestDrive() {
        initializeDatabase();
    }

    private void initializeDatabase() {
//        PersonBean personBean = new PersonBeanImpl().set;
    }
}
