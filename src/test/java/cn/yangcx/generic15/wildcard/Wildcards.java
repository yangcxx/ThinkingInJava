package cn.yangcx.generic15.wildcard;

import cn.yangcx.generic15.Holder;

/**
 * @author YANGCX
 * @date 2021/8/9 8:07
 */
public class Wildcards {

    static void rawArgs(Holder holder, Object arg) {
        // todo warning: Unchecked call to 'setT(T)' as a member of raw type 'cn.yangcx.generic15.Holder'
        holder.setT(arg);
        holder.setT(new Wildcards());
        // 没有任何T类型对象，只能是Object
        Object t = holder.getT();
    }

    static void unboundedArg(Holder<?> holder, Object arg) {
        // todo error: Required type:capture of ?
        // holder.setT(arg);
        // holder.setT(new Wildcards());

        Object t = holder.getT();
    }

    static <T> T exact1(Holder<T> holder) {
        return holder.getT();
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.setT(arg);
        return holder.getT();
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        // todo error: Required type:capture of ? extends T
        // holder.setT(arg);
        return holder.getT();
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.setT(arg);
        Object object = holder.getT();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);
    }
}
