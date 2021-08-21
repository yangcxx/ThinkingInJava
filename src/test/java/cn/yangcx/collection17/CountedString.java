package cn.yangcx.collection17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/8/21 14:50
 */
public class CountedString {

    private static final List<String> created = new ArrayList<>();

    private final String s;

    private int id = 0;

    public CountedString(String str) {
        s = str;
        created.add(s);
        for (String s1 : created) {
            if (s1.equals(s)) {
                id++;
            }
        }
    }

    @Override
    public String toString() {
        return "String: " + s + " id: " + id + " hashCode: " + hashCode();
    }

    /**
     * 1、给 int 变量 result 赋予某个非零常量，如17
     * 2、为对象内每个有意义的域f（每个可以做equals()操作的域）计算出一个int散列码c
     * 3、合并计算得到的散列码 result = 37 * result + c
     * 4、返回　result
     * 5、检查hashCode()最后生成的结果，确保每个相同的对象都有相同的散列码
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString && s.equals(((CountedString) obj).s) && id == ((CountedString) obj).id;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            // Auto box
            map.put(cs[i], i);
        }
        print(map);
        for (CountedString csString : cs) {
            print("Looking up " + csString);
            print(map.get(csString));
        }
    }
}
