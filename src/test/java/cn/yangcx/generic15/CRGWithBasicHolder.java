package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/8/10 6:59
 */
public class CRGWithBasicHolder {

    public static void main(String[] args) {
        Subtype subtype1 = new Subtype();
        Subtype subtype2 = new Subtype();

        // cxy 泛型基类变成了一种其所有导出类的公共功能的模板
        subtype1.set(subtype2);
        Subtype subtype3 = subtype1.get();
        subtype1.f();
    }

}

class Subtype extends BasicHolder<Subtype> {
    // todo 古怪的循环泛型 CRG：基类用导出类替代其参数
}

class BasicHolder<T> {
    T element;

    void set(T item) {
        this.element = item;
    }

    T get() {
        return this.element;
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }

}
