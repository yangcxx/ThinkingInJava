package cn.yangcx.inner_class10.test;

/**
 * @author YANGCX
 * @date 2021/6/24 7:17
 */
public class Test3 {

    public T1 getT1(int i) {
        return new T1(i) {
            // 此处就是继承自 T1 的匿名内部类
        };
    }

}

class T1 {
    private int i;

    public T1(int i) {
        this.i = i;
    }
}

class T2 {
    public T1 t1(int i) {
        return new T1(i);
    }
}
