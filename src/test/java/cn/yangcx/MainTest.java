package cn.yangcx;

import cn.yangcx.typeinfo14.Person;

/**
 * @author YANGCX
 * @date 2021/4/11 10:15
 */
public class MainTest {

    private String str;

    private String str2;

    public MainTest(String str2) {
        this.str2 = str2;
    }

    public static void main(String[] args) {
        MainTest mt = new MainTest("str2");
        System.err.println(mt.getStr());
        System.out.println(mt.getStr2());
        System.out.println("===============");
        Class<MainTest> mtClazz = MainTest.class;
        Class<Object> objClazz = Object.class;
        System.out.println(objClazz.isAssignableFrom(mtClazz));
        System.out.println("===============");
        Person person = new Person("111", ":222", "3333");
        System.out.println(person);
        System.err.println(Person.NullPerson.NULL);
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
