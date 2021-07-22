package cn.yangcx.polymorphism08;

/**
 * @author YANGCX
 * @date 2021/6/6 10:28
 */
public class Sandwich extends PortableLunch {

    // 4
    private Bread bread = new Bread();
    // 5
    private Cheese cheese = new Cheese();
    // 6
    private Lettuce lettuce = new Lettuce();

    public Sandwich() {
        // 7
        System.out.println("7  Sandwich");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}

class Meal {
    // 1
    public Meal() {
        System.out.println("1  Meal");
    }
}

class Bread {
    public Bread() {
        System.out.println("4  Bread");
    }
}

class Cheese {
    public Cheese() {
        System.out.println("5  Cheese");
    }
}

class Lettuce {
    public Lettuce() {
        System.out.println("6  Lettuce");
    }
}

class Lunch extends Meal {
    // 2
    public Lunch() {
        System.out.println("2  Lunch");
    }
}

class PortableLunch extends Lunch {
    // 3
    public PortableLunch() {
        System.out.println("3  PortableLunch");
    }
}
