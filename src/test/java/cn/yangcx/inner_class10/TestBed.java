package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/27 11:06
 */
public class TestBed {

    public void f() {
        System.out.println("TestBed.f()");
    }

    public static class Tester{
        public static void main(String[] args) {
            TestBed tb = new TestBed();
            tb.f();
        }
    }

}
