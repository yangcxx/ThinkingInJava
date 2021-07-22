package cn.yangcx.access06.dessert;

import cn.yangcx.access06.Cookie;

/**
 * @author YANGCX
 * @date 2021/5/21 8:01
 */
public class ChocolateChip extends Cookie {

    public ChocolateChip() {
        System.out.println("Chocolate constructor");
    }

    public void privateMethod() {
        System.out.println("子类可以拥有和父类相同定义的private方法！！，但肯定是不能覆盖的");
    }

    public void chomp() {
        // cxy 即使是继承，也无法访问 default 成员
        //  protected 允许继承类进行访问
        // bite();
        System.out.println("chomp");
    }

    public static void main(String[] args) {
        ChocolateChip cc = new ChocolateChip();
        cc.chomp();
    }
}
