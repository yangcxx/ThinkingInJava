package cn.yangcx.generic15;

/**
 * @author YANGCX
 * @date 2021/7/26 7:03
 */
public class LinkedStack<T> {

    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return (item == null && next == null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }

    private Node<T> top = new Node<>();

    public void push(T item) {
        // cxy top 每一次都会保留上一次的push结果，形成链式结构
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            // todo "末端哨兵"
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> ls = new LinkedStack<>();
        for (String s : "Phasers on stun!".split(" ")) {
            ls.push(s);
        }
        String s;
        while ((s = ls.pop()) != null) {
            System.out.println(s);
        }
    }

}
