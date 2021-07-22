package cn.yangcx.polymorphism08;

/**
 * @author YANGCX
 * @date 2021/6/6 17:12
 */
public class RTTI {

    public static void main(String[] args) {
        Useful[] usefuls = {new Useful(), new MoreUseful()};
        usefuls[0].f();
        usefuls[1].g();

        // usefuls[1].u();
        ((MoreUseful) usefuls[1]).u();
        // 强制类型转换。ClassCaseException
        ((MoreUseful) usefuls[0]).u();
    }

}

class Useful {
    public void g() {
    }

    public void f() {
    }
}

class MoreUseful extends Useful {

    public void u() {
    }

    public void v() {
    }

    public void w() {
    }

    @Override
    public void g() {
        super.g();
    }

    @Override
    public void f() {
        super.f();
    }
}
