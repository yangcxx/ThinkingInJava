package cn.yangcx.typeinfo14.tt;

/**
 * @author YANGCX
 * @date 2021/7/23 7:50
 */
public class InterfaceViolation {

    public static void main(String[] args) {
        A a = new B();
        a.f();
        // 无法访问 B 新增的方法
        // a.g();
        System.out.println(a.getClass().getCanonicalName());
        // 判断类型后强制类型转换 fixme 给既定实现新增了自定义方法
        B b = (B) a;
        b.g();
    }

}
