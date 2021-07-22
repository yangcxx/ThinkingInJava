package cn.yangcx.typeinfo14.proxy;

/**
 * @author YANGCX
 * @date 2021/7/22 11:02
 */
public class RealObj implements Interface {
    @Override
    public void doSth() {
        System.out.println("RealObj doSth");
    }

    @Override
    public void sthElse(String arg) {
        System.out.println("RealObj sthElse");
    }
}
