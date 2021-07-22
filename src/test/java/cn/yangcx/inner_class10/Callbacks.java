package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/27 16:52
 */
public class Callbacks {

    public static void main(String[] args) {
        Callee1 callee1 = new Callee1();
        Callee2 callee2 = new Callee2();
        // Other operation + num
        MyIncrement.f(callee2);
        Caller caller1 = new Caller(callee1);
        Increment callbackReference = callee2.getCallbackReference();
        Caller caller2 = new Caller(callbackReference);
        // num
        caller1.go();
        // num
        caller1.go();
        // Other operation + num
        caller2.go();
        // Other operation + num
        caller2.go();
    }

}

interface Increment {
    void increment();
}

// 独立类实现接口
class Callee1 implements Increment {

    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    public void increment() {
        System.out.println("Other operation");
    }

    static void f(MyIncrement mi) {
        mi.increment();
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    // 闭包，内部类实现接口
    private class Closure implements Increment {
        @Override
        public void increment() {
            // .this 外部类对象引用
            // 提供了一个返回 Callee2 的“钩子”hook
            Callee2.this.increment();
        }
    }

    Increment getCallbackReference() {
        return new Closure();
    }
}

class Caller {
    private final Increment callbackReference;

    public Caller(Increment callbackReference) {
        this.callbackReference = callbackReference;
    }

    void go() {
        callbackReference.increment();
    }
}