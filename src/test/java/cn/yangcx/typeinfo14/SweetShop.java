package cn.yangcx.typeinfo14;

/**
 * @author YANGCX
 * @date 2021/7/19 7:38
 */
public class SweetShop {

    public static void main(String[] args) {
        System.out.println("Inside Main");
        new Candy();
        System.out.println("After Creating Candy");
        try {
            Class.forName("cn.yangcx.typeinfo14.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't found Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After Creating Cookie");
    }

}

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}
