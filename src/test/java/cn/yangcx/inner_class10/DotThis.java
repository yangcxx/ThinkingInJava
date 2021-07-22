package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/22 7:17
 */
public class DotThis {

    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            // todo 在内部类中使用 .this 返回所在外部类
            return DotThis.this;
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        Inner inner = dt.inner();
        inner.outer().f();
    }

}
