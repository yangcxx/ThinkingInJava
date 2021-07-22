package cn.yangcx.typeinfo14.pets;

/**
 * @author YANGCX
 * @date 2021/7/20 7:22
 */
public class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    public Dog() {
        System.out.println("Dog init");
    }
}
