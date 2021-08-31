package cn.yangcx.enum19;

import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/8/31 7:21
 */
public enum OverrideConstantSpecific {

    NUT, BOLT,
    WASHER {
        // todo 可以覆盖普通方法
        void f() {
            print("Overridden method");
        }
    };


    void f() {
        print("default behavior");
    }
}
