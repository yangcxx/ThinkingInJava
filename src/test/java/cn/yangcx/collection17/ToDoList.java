package cn.yangcx.collection17;

import java.util.PriorityQueue;

/**
 * @author YANGCX
 * @date 2021/8/20 7:18
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {

    static class ToDoItem implements Comparable<ToDoItem> {

        private final char primary;

        private final int secondary;

        private final String item;

        public ToDoItem(char primary, int secondary, String item) {
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }

        @Override
        public int compareTo(ToDoItem tdi) {
            if (primary > tdi.primary) {
                return 1;
            }
            if (primary == tdi.primary) {
                if (secondary > tdi.secondary) {
                    return 1;
                } else if (secondary == tdi.secondary) {
                    return 0;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary) + secondary + " : " + item;
        }
    }

    public void add(String td, char pri, int sec) {
        super.add(new ToDoItem(pri, sec, td));
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Empty trash", 'C', 4);
        toDoList.add("Feed dog", 'A', 2);
        toDoList.add("Feed bird", 'B', 7);
        toDoList.add("Mow lawn", 'C', 4);
        toDoList.add("Water lawn", 'A', 1);
        toDoList.add("Feed cat", 'B', 1);
        while (!toDoList.isEmpty()) {
            System.out.println(toDoList.remove());
        }
    }

}
