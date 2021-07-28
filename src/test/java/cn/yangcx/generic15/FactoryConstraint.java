package cn.yangcx.generic15;

import lombok.Getter;
import lombok.Setter;

/**
 * @author YANGCX
 * @date 2021/7/28 21:50
 */
public class FactoryConstraint {

    public static void main(String[] args) {
        // todo 如果需要通过泛型创建对象，建议使用显示的工厂，并将限制其类型
        Foo2<Integer> integerFoo21 = new Foo2<>(new IntegerFactory());
        System.out.println(integerFoo21.getX());
        Foo2<Widget> widgetFoo22 = new Foo2<>(new Widget.Factory());
        System.out.println(widgetFoo22.getX());
    }

}

interface FactoryI<T> {
    T create();
}

@Getter
@Setter
class Foo2<T> {
    private T x;

    /**
     * 传递一个工厂执行对象创建 todo 设计模式？？
     *
     * @param factory 工厂对象
     * @param <F>     工厂泛型类
     */
    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }
}

class IntegerFactory implements FactoryI<Integer> {

    @Override
    public Integer create() {
        return 0;
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}