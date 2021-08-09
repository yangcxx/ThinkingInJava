package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/8/9 21:29
 */
public class CaptureConversion {

    static <T> void f1(Holder<T> holder) {
        T t = holder.getT();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder);
    }

    // @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder raw = new Holder<>(1);
        // warning: Unchecked assignment: 'cn.yangcx.generic15.Holder' to 'cn.yangcx.generic15.Holder<java.lang.Object>'
        // f1(raw);

        // todo 捕获转换：f1接受的参数是?，f1接受的参数是T具体类型。通过f2调用f1，f2通过传递的参数推导出了真实的参数类型
        f2(raw);

        Holder rawBasic = new Holder();
        // warning: Unchecked call to 'setT(T)' as a member of raw type 'cn.yangcx.generic15.Holder'
        rawBasic.setT(new Object());

        f2(rawBasic);

        Holder<?> wildcard = new Holder<>(1.0);
        f2(wildcard);
    }
}
