package cn.yangcx.typeinfo14;

import cn.yangcx.typeinfo14.tt.A;
import cn.yangcx.typeinfo14.tt.HiddenC;

import java.lang.reflect.Method;

/**
 * @author YANGCX
 * @date 2021/7/23 7:59
 */
public class HiddenImplementation {

    public static void main(String[] args) {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getCanonicalName());
        // todo C 仅有包访问权限
        // if (a instanceof C) {
        //     C c = (C) a;
        //     c.g();
        // }
        // todo 通过反射仍然可以访问接口规定以外的方法
        // fixme 仍然无法避免访问派生的方法
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    public static void callHiddenMethod(Object a, String methodName) {
        try {
            Method method = a.getClass().getDeclaredMethod(methodName);
            // private 方法也可以被访问
            method.setAccessible(true);
            method.invoke(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
