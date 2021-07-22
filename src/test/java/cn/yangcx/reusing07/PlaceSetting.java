package cn.yangcx.reusing07;

/**
 * @author YANGCX
 * @date 2021/5/28 7:32
 */
public class PlaceSetting extends Customer {

    // cxy @Override 注解是 JavaSE5 加入的

    private Spoon sp;
    private Fork fk;
    private Knife kn;
    private DinnerPlate pl;

    public PlaceSetting(int i) {
        // cxy 虽然编译器强制在构造器起始处初始化基类，但并不要求将成员对象也初始化
        super(i + 1);
        sp = new Spoon(i + 2);
        fk = new Fork(i + 3);
        kn = new Knife(i + 4);
        pl = new DinnerPlate(i + 5);
        System.out.println("PlaceSetting constructor==> " + i);
    }

    public static void main(String[] args) {
        // cxy 除了内存以外，不能依赖垃圾回收器做任何事情；如果需要清理，最好是编写自己的清理方法，但不要使用 finalize() 方法
        PlaceSetting ps = new PlaceSetting(9);
        System.out.println(ps);
    }
}


class Plate {
    public Plate(int i) {
        System.out.println("Plate constructor==> " + i);
    }
}

class DinnerPlate extends Plate {
    public DinnerPlate(int i) {
        super(i);
        System.out.println("DinnerPlate constructor==> " + i);
    }
}

class Utensil {
    public Utensil(int i) {
        System.out.println("Utensil constructor==> " + i);
    }
}

class Spoon extends Utensil {
    public Spoon(int i) {
        super(i);
        System.out.println("Spoon constructor==> " + i);
    }
}

class Fork extends Utensil {
    public Fork(int i) {
        super(i);
        System.out.println("Fork constructor==> " + i);
    }
}

class Knife extends Utensil {
    public Knife(int i) {
        super(i);
        System.out.println("Knife constructor==> " + i);
    }
}

class Customer {
    public Customer(int i) {
        System.out.println("Customer constructor==> " + i);
    }
}
