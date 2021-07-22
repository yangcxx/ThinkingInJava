package cn.yangcx.access06;

/**
 * @author YANGCX
 * @date 2021/5/21 7:41
 */
public class Cookie {

    public Cookie() {
        System.out.println("Cookie constructor");
    }

    // cxy 只能被位于同包下的类访问（子包不行；继承类也不行）
    //  protected 关键字允许继承类进行访问
    void bite() {
        System.out.println("bite");
    }

    public void eat() {
        System.out.println("eat");
    }

    private void privateMethod() {
        System.out.println("子类能覆盖父类的private方法？？");
    }
}
