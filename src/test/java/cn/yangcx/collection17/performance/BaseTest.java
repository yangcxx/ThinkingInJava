package cn.yangcx.collection17.performance;

/**
 * @author YANGCX
 * @date 2021/8/21 15:13
 */
public abstract class BaseTest<C> {

    String name;

    public BaseTest(String name) {
        this.name = name;
    }

    protected abstract int test(C container, TestParam tp);

}
