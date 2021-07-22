package cn.yangcx.jcf11;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author YANGCX
 * @date 2021/7/1 6:55
 */
public class Stack<T> {

    private final LinkedList<T> storage = new LinkedList<>();

    public void push(T t) {
        storage.addFirst(t);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public static void main(String[] args) {
        // 默认按照字典序升序
        TreeSet<String> treeSet1 = new TreeSet<>();
        // todo 按照字母序排序
        TreeSet<String> treeSet2 = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "storage=" + storage +
                '}';
    }
}
