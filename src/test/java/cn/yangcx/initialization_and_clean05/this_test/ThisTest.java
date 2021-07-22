package cn.yangcx.initialization_and_clean05.this_test;

/**
 * TODO<br/>
 * Date: 2020/6/18 7:49 <br/>
 *
 * @author YANGCX
 */
public class ThisTest {

    public static void main(String[] args) {
        new Person().eat(new Apple("QingPingGuo"));
    }

}

class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }
}

class Peeler {

    public static Apple peel(Apple apple) {
        System.out.println("remove " + apple.getType() + "'s peel");
        return apple;
    }
}

class Apple {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Apple(String type) {
        this.type = type;
    }

    Apple getPeeled() {
        // TODO this 关键字的使用：仅在必要时使用 this
        return Peeler.peel(this);
    }
}
