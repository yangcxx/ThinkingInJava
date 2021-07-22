package cn.yangcx.interface09;

/**
 * @author YANGCX
 * @date 2021/6/18 7:52
 */
public class Factories {

    public static void serviceConsumer(ServiceFactory sf) {
        Service service = sf.getService();
        service.m1();
        service.m2();
    }

    public static void main(String[] args) {
        // todo 将具体实现类交由调用时决策
        serviceConsumer(new Impl1Factory());
        serviceConsumer(new Impl2Factory());
    }

}

interface Service {
    void m1();

    void m2();
}

interface ServiceFactory {
    Service getService();
}

class Impl1 implements Service {

    @Override
    public void m1() {
        System.out.println("Impl1.m1");
    }

    @Override
    public void m2() {
        System.out.println("Impl1.m2");
    }

    // 2、使用匿名内部类返回工厂
    public static ServiceFactory factory = Impl1::new;
}

// 1、独立实现工厂方法
class Impl1Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Impl1();
    }
}

class Impl2 implements Service {

    // 2、使用匿名内部类返回工厂
    public static ServiceFactory factory = Impl2::new;

    @Override
    public void m1() {
        System.out.println("Impl2.m1");
    }

    @Override
    public void m2() {
        System.out.println("Impl2.m2");
    }
}

// 1、独立实现工厂方法
class Impl2Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Impl2();
    }
}
