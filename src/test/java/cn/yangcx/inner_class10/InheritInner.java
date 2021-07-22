package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/28 21:45
 */
public class InheritInner extends WithInner.Inner {

    public InheritInner(WithInner wi) {
        // todo 无法使用默认的构造器实现，必须提供外围类的引用
        wi.super();
    }
}

class WithInner {
    class Inner {
    }
}
