package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/27 11:12
 */
public class ClassInInterfaceImpl implements ClassInInterface {
    @Override
    public void howdy() {
        // 访问实现接口的内部类
        Test t = new Test();
        t.howdy();
    }
}
