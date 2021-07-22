package cn.yangcx.jcf11;

import java.util.*;

/**
 * @author YANGCX
 * @date 2021/7/2 7:44
 */
public class MultiIterableClass extends IterableClass {

    public Iterable<String> reversed() {
        return () -> new Iterator<String>() {

            int current = words.length - 1;

            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public String next() {
                return words[current--];
            }
        };
    }

    public Iterable<String> randomized() {
        return () -> {
            // 使用新的 ArrayList 包装了数组结果，使下一步打乱操作不会影响到原数组
            List<String> shuffled = new ArrayList<>(Arrays.asList(words));
            Collections.shuffle(shuffled, new Random(47));
            return shuffled.iterator();
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mic = new MultiIterableClass();
        for (String s : mic.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : mic.randomized()) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : mic) {
            System.out.print(s + " ");
        }
    }

}

