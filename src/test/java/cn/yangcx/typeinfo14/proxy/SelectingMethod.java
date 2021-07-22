package cn.yangcx.typeinfo14.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author YANGCX
 * @date 2021/7/22 11:14
 */
public class SelectingMethod implements InvocationHandler {

    private final Object proxied;

    public SelectingMethod(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        if ("interesting".equals(name)) {
            System.out.println("Proxy detected the interesting method");
        }
        return method.invoke(proxied, args);
    }
}
