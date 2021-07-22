package cn.yangcx.string13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/7/16 7:16
 */
public class InfiniteRecursion {

    @Override
    public String toString() {
        return "InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }
}
