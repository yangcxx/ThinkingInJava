package cn.yangcx.enum19.menu;

/**
 * @author YANGCX
 * @date 2021/8/30 22:54
 */
public class Meal {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course value : Course.values()) {
                Food food = value.randomSelection();
                System.out.println(food);
            }
            System.out.println("===");
        }
    }

}
