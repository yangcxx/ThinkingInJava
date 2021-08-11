package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/8/10 6:49
 */
public class HijackInterface {


}

class ComparablePet implements Comparable<ComparablePet> {

    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}

class Cat extends ComparablePet implements Comparable<ComparablePet> {

    @Override
    public int compareTo(ComparablePet o) {
        return super.compareTo(o);
    }
}