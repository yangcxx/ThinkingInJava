package cn.yangcx.generic15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author YANGCX
 * @date 2021/8/9 21:43
 */
public class ByteSet {

    public static void main(String[] args) {
        Byte[] possibles = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Set<Byte> mySet = new HashSet<>(Arrays.asList(possibles));

        // todo Arrays.asList(1, 2, 3, 4, 5, 6) 实际上是一个 List<Integer>
        // Set<Byte> mySet2 = new HashSet<Byte>(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

}
