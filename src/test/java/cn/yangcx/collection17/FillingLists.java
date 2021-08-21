package cn.yangcx.collection17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/8/17 7:22
 */
public class FillingLists {

    public static void main(String[] args) {
        // todo 都是使用的同一个对象进行填充
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4, new StringAddress("Hello")));
        System.out.println(list);
        // todo 直接替换已有元素
        Collections.fill(list, new StringAddress("World!"));
        System.err.println(list);
    }

}

class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}
