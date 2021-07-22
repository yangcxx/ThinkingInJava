package cn.yangcx.access06.sub;

import cn.yangcx.access06.Cookie;

/**
 * @author YANGCX
 * @date 2021/5/21 7:41
 */
public class Dinner {

    public static void main(String[] args) {
        Cookie cookie = new Cookie();
        // cxy bite方法仅提供了包访问权限，即使是位于子包下也不能访问
        // cookie.bite();
        cookie.eat();
    }

}
