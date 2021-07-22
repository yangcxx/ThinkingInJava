package cn.yangcx.polymorphism08.test;

/**
 * @author YANGCX
 * @date 2021/6/6 10:08
 */
public class FieldAccess {

    public static void main(String[] args) {
        Super sup = new Sub();
        // sup.field 基类的字段值
        // sup.getField 调用子类的重载方法
        System.out.println("sup.field = " + sup.field + ", sup.getField() = " + sup.getField());

        // 导出类 Sub 拥有两个 field 域：自己的和从基类继承来的；访问基类的 field 域只能通过 super 进行访问
        Sub sub = new Sub();
        System.out.println("sub.field = " + sub.field + ", sub.getField() = " + sub.getField() + ", sub.getSuperField() = " + sub.getSuperField());
    }

}

class Super {
    public int field = 0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.getField();
    }
}

