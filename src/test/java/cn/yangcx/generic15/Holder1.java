package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/7/25 17:28
 */
public class Holder1<T> {

    private T t;

    public Holder1(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        AutoMobile am = new AutoMobile();
        Holder1<AutoMobile> holder = new Holder1<>(am);
        AutoMobile t = holder.getT();
        // todo 泛型与多态不冲突
        System.err.println(t);
    }
}
