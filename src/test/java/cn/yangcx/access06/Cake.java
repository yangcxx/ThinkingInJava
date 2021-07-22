package cn.yangcx.access06;

/**
 * @author YANGCX
 * @date 2021/5/24 21:18
 */
public class Cake {

    public static void main(String[] args) {
        Cookie cookie = new Cookie();
        // cxy 相同包才可以访问 default 成员
        cookie.bite();
    }

}
