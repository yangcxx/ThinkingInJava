package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/23 7:08
 */
public class Parcel5 {

    public Destination destination(String s) {
        // cxy 局部内部类：定义在方法中的内部类；作用范围仅限于此方法
        //  可以在当前及子目录下的任意类中对某个内部类使用 PDestination 类标识符，不会有命名冲突
        class PDestination implements Destination {

            private final String label;

            public PDestination(String label) {
                this.label = label;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

}
