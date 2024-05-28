package proxypattern.reflectproxy;

public class Proxy {

    PersonBean getOwnerProxy(PersonBean personBean) {
        return (PersonBean) java.lang.reflect.Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new OwnerInvocationHandler(personBean)
        );
    }

    PersonBean getNonOwnerProxy(PersonBean personBean) {
        return (PersonBean) java.lang.reflect.Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(personBean)
        );
    }
}
