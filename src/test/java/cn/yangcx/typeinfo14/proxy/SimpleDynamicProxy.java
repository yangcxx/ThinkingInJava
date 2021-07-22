package cn.yangcx.typeinfo14.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 一个简单的动态代理
 *
 * @author YANGCX
 * @date 2021/7/22 10:54
 */
public class SimpleDynamicProxy {

    public static void consumer(Interface iface) {
        iface.doSth();
        iface.sthElse("bababa");
    }

    public static void main(String[] args) {
        RealObj ro = new RealObj();
        consumer(ro);
        System.out.println();
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(ro));
        // todo 具体的方法调用都是通过代理类执行的
        consumer(proxy);
    }

}

class DynamicProxyHandler implements InvocationHandler {

    private final Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // todo 对接口的调用会被转换为对代理的调用
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + Arrays.toString(args));
        if (args != null) {
            for (Object arg : args) {
                System.out.println("   " + arg);
            }
        }
        // todo 使用 Method.invoke 方法将请求转发给被代理对象
        return method.invoke(proxied, args);
    }
}
