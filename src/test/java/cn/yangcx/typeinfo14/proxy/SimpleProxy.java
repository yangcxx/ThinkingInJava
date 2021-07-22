package cn.yangcx.typeinfo14.proxy;

/**
 * @author YANGCX
 * @date 2021/7/22 11:02
 */
public class SimpleProxy implements Interface {

    private final Interface proxied;

    SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSth() {
        System.out.println("SimpleProxy doSth");
        proxied.doSth();
    }

    @Override
    public void sthElse(String arg) {
        System.out.println("SimpleProxy sthElse");
        proxied.sthElse(arg);
    }
}
