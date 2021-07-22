package cn.yangcx.inner_class10.test;

/**
 * @author YANGCX
 * @date 2021/6/23 6:59
 */
public class Test1 {

    private String field;

    private void f() {
        System.out.println("Test1.f(),field==> " + field);
    }

    private void f2() {
        InnerClass1 innerClass1 = new InnerClass1();
        innerClass1.changeOuterField("abcd");
        innerClass1.privateMethod();
    }

    public class InnerClass1 {
        public void changeOuterField(String newField) {
            field = newField;
            f();
        }

        private void privateMethod() {
            System.out.println("Test1.InnerClass1.privateMethod");
        }
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.f2();

        InnerClass1 innerClass1 = test1.new InnerClass1();
        innerClass1.privateMethod();
    }

}
