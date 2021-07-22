package cn.yangcx.typeinfo14;

import java.util.Arrays;

/**
 * @author YANGCX
 * @date 2021/7/19 7:47
 */
public class ToyTest implements ToyInterface {

    static void printInfo(Class cc) {
        // getName 返回全限定类名
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        // getSimpleName 返回不含包名的类名
        System.out.println("Simple name: " + cc.getSimpleName());
        // getCanonicalName 返回全限定类名
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    @Override
    public void m() {
        System.out.println("Implement method from ToyInterface");
    }

    public static void main(String[] args) {
        Class<ToyTest> toyTestClass = ToyTest.class;
        printInfo(toyTestClass);
        // getInterfaces 返回实现的接口
        Class<?>[] interfaces = toyTestClass.getInterfaces();
        System.out.println(Arrays.toString(interfaces));
        // todo 查询其直接基类 cxy 接口并不是其直接基类
        Class<? super ToyTest> superclass = toyTestClass.getSuperclass();
        System.out.println(superclass);
        Class<Boolean> type = Boolean.TYPE;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(type.equals(booleanClass));
    }

}

interface ToyInterface {
    void m();
}
