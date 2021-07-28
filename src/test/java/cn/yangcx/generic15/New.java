package cn.yangcx.generic15;

import cn.yangcx.typeinfo14.pets.Pet;

import java.util.*;

/**
 * @author YANGCX
 * @date 2021/7/26 21:43
 */
public class New {

    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    public static <T> Set<T> set() {
        return new HashSet<>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = New.map();
        List<String> list = New.list();
        Set<String> set = New.set();
        Queue<String> queue = New.queue();

        // 自动类型推断
        Map<String, List<? extends Pet>> map1 = New.map();
    }

}
