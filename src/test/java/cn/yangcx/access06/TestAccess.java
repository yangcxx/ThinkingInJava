package cn.yangcx.access06;

// cxy 一个编译文件内也可以不带任何 public 类信息，此情况下可以随意对 class 文件命名

class A {
    static {
        System.out.println("A");
    }
}


class B {
    static {
        System.out.println("B");
    }
}
