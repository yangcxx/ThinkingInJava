package cn.yangcx.typeinfo14.proxy;

/**
 * 一个简单的静态代理
 *
 * @author YANGCX
 * @date 2021/7/22 10:43
 */
public class SimpleStaticProxy {

    public static void consumer(Interface iface) {
        iface.doSth();
        iface.sthElse("bababa");
    }

    public static void main(String[] args) {
        consumer(new RealObj());
        System.out.println();
        consumer(new SimpleProxy(new RealObj()));
    }

}
