package cn.yangcx.generic15.wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/8/4 7:44
 */
public class GenericsAndCovariance {

    public static void main(String[] args) {
        // todo List<Number>在类型上不等价于List<Integer>
        List<? extends Fruit> fList = new ArrayList<Apple>();
        List<? extends Fruit> fList2 = new ArrayList<>();
        List<? super Apple> fList3 = new ArrayList<>();
        List<?> fList4 = new ArrayList<>();

        // todo 编译错误
        // fList.add(new Apple());
        // fList.add(new Fruit());
        // fList.add(new Object());
        fList.add(null);
        // todo 编译错误
        // fList2.add(new Apple());
        // fList2.add(new Fruit());
        // fList2.add(new Object());
        // todo 编译错误
        // fList3.add(new Fruit());
        fList3.add(new Apple());
        fList3.add(new Jonathan());
        // fList3.add(new Object());

        // Fruit fruit1 = fList.get(0);
        // Fruit fruit2 = fList2.get(0);
        // Object obj1 = fList3.get(0);
        // Object obj2 = fList4.get(0);


        // ? extends T，作为方法参数只接受T及其子类
        m1(Arrays.asList(new Apple(), new Jonathan()));
        // ? super T，可以接受任意参数
        m2(Arrays.asList(new Apple(), new Fruit(), new Jonathan(), new Orange(), new Object()));
        // ? ，可以接受任意参数
        m3(Arrays.asList(new Apple(), new Fruit(), new Jonathan(), new Orange(), new Object()));
    }

    public static void m1(List<? extends Apple> apples) {
        for (Apple apple : apples) {
            System.out.println(apple.getClass().getCanonicalName());
        }
    }

    public static void m2(List<? super Apple> apples) {
        for (Object apple : apples) {
            System.out.println(apple.getClass().getCanonicalName());
        }
    }

    public static void m3(List<?> list) {
        for (Object o : list) {
            System.out.println(o.getClass().getCanonicalName());
        }
    }

}
