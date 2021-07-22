package cn.yangcx.polymorphism08;

/**
 * @author YANGCX
 * @date 2021/6/6 16:49
 */
public class CovariantReturn {

    public static void main(String[] args) {
        Mill mill = new Mill();
        Grain grain = mill.process();
        System.out.println(grain);

        mill = new WheatMill();
        // 调用 WheatMill 的方法
        grain = mill.process();
        System.out.println(grain);
    }

}

class Grain {
    @Override
    public String toString() {
        return "Grain{}";
    }
}

class Wheat extends Grain {
    @Override
    public String toString() {
        return "Wheat{}";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    // cxy 子类覆盖基类方法，返回值返回可以小于或等于基类定义
    //   协变返回类型 JavaSE5 新功能
    @Override
    Wheat process() {
        return new Wheat();
    }
}
