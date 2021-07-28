package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/7/28 7:34
 */
public class Manipulator2<T extends HasF> {

    private final T obj;

    public Manipulator2(T obj) {
        this.obj = obj;
    }

    public void manipulation() {
        obj.f();
    }
}

class HasF {

    void f() {
        System.out.println("HasF.f()");
    }

}
