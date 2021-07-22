package cn.yangcx.interface09;

/**
 * @author YANGCX
 * @date 2021/6/8 7:27
 */
public class Adventure {

    public static void t(CanFight x) {
        x.fight();
    }

    public static void u(CanSwim x) {
        x.swim();
    }

    public static void v(CanFly x) {
        x.fly();
    }

    public static void w(ActionCharacter x) {
        x.fight();
    }

    public static void x(CanClimb x) {
        x.climb();
    }

    public static void main(String[] args) {
        Hero h = new Hero();
        t(h);
        u(h);
        v(h);
        w(h);
        x(h);
    }

}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly, CanClimb {

    @Override
    public void fly() {
        System.out.println("Hero fly");
    }

    @Override
    public void swim() {
        System.out.println("Hero swim");
    }

    @Override
    public void fight() {
        // 实现接口定义后会隐藏父类的实现
        System.out.println("Hero fight");
    }

    @Override
    public void climb() {
        System.out.println("Hero climb");
    }
}

class ActionCharacter {
    public void fight() {
        System.out.println("ActionCharacter fight");
    }
}

interface CanClimb {
    void climb();
}

interface CanFly {
    void fly();
}

interface CanSwim {
    void swim();
}

interface CanFight {
    void fight();
}
