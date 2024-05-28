package proxypattern.reflectproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NonOwnerInvocationHandler implements InvocationHandler {
    PersonBean personBean;
    public NonOwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            if (method.getName().startsWith("setHotOrNotRating")) {
                return method.invoke(personBean, args);
            } else if (method.getName().equals("set")) {
                throw new IllegalAccessException();
            } else if (method.getName().startsWith("get")) {
                return method.invoke(personBean, args);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
