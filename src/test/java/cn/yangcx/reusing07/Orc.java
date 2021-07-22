package cn.yangcx.reusing07;

/**
 * @author YANGCX
 * @date 2021/5/29 8:26
 */
public class Orc extends Villain {

    private int orcNumber;

    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber) {
        // cxy　可以访问继承的父类的　protected 方法
        set(name);
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
        return "Orc{" +
                "orcNumber=" + orcNumber +
                "} " + super.toString();
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Limburger", 12);
        System.out.println("Orc ==> " + orc);
        orc.change("Bob", 19);
        System.out.println("new Orc ==> " + orc);
    }

}

class Villain {
    private String name;

    protected void set(String nm) {
        this.name = nm;
    }

    public Villain(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Villain{" +
                "name='" + name + '\'' +
                '}';
    }
}
