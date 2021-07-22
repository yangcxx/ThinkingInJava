package cn.yangcx.typeinfo14;

import cn.yangcx.util.Null;

/**
 * @author YANGCX
 * @date 2021/7/22 11:21
 */
public class Person {

    private final String first;
    private final String last;
    private final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class NullPerson extends Person implements Null {

        private NullPerson() {
            super("None", "None", "None");
            System.out.println("Initialization NullPerson");
        }

        // 空对象都是单例的
        public static final Person NULL = new NullPerson();

        @Override
        public String toString() {
            return "NullPerson";
        }
    }
}
