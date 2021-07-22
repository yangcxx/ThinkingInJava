package cn.yangcx;

import cn.yangcx.reusing07.ProtectedParent;
import lombok.ToString;

/**
 * @author YANGCX
 * @date 2021/5/29 8:38
 */
@ToString(callSuper = true)
public class ProtectedSon extends ProtectedParent {

    private String son;

    public ProtectedSon(String parent, String son) {
        super(parent);
        this.son = son;
    }

    public void set(String p, String s) {
        this.son = s;
        // cxy protected 可以子类进行访问（不限定包）
        changeName(p);
    }

    public static void main(String[] args) {
        ProtectedSon ps = new ProtectedSon("oldP", "oldS");
        System.out.println("ps ==> " + ps);
        ps.set("newP", "newS");
        System.out.println("ps ==> " + ps);
    }
}
