package cn.yangcx.polymorphism08.test;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author YANGCX
 * @date 2021/6/1 7:24
 */
public class CycleTest {

    public static void main(String[] args) {
        Tricycle cycle = new Tricycle("Tricycle", 111);
        Bicycle cycle2 = new Bicycle("Bicycle", 222);
        Unicycle cycle3 = new Unicycle("Unicycle", 333);
        cycle.ride(cycle);
        cycle2.ride(cycle2);
        cycle3.ride(cycle3);
    }

}

class Tricycle extends Cycle {

    public Tricycle(String name, int wheels) {
        super(name, wheels);
    }

    @Override
    public void ride(Cycle cycle) {
        super.ride(cycle);
    }
}

class Bicycle extends Cycle {

    public Bicycle(String name, int wheels) {
        super(name, wheels);
    }

    @Override
    public void ride(Cycle cycle) {
        super.ride(cycle);
    }
}

class Unicycle extends Cycle {

    public Unicycle(String name, int wheels) {
        super(name, wheels);
    }

    @Override
    public void ride(Cycle cycle) {
        super.ride(cycle);
    }
}

@Data
@AllArgsConstructor
class Cycle {

    private String name;

    private int wheels;

    public void ride(Cycle cycle) {
        System.out.println(cycle.getName() + "'s name is " + cycle.getName() + " ,wheels: " + cycle.wheels());
    }

    public int wheels() {
        return this.wheels;
    }
}

