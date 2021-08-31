package cn.yangcx.enum19;

import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/8/31 7:12
 */
public class NotClasses {

    // void f1(LikeClasses.WINKEN instance) {}

}

enum LikeClasses {
    WINKEN {
        void behavior() {
            print("Behavior1");
        }
    },
    BLINKEN {
        void behavior() {
            print("Behavior2");
        }
    },
    NOD {
        void behavior() {
            print("Behavior3");
        }
    };

    abstract void behavior();
}
