package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/7/28 7:51
 */
public class ErasureAndInheritance {


}

// todo 编译报错
// class Derived3 extends GenericBase<?> {
//
// }

class Derived2 extends GenericBase {
}

class Derived1<T> extends GenericBase<T> {
}

class GenericBase<T> {
    private T element;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
