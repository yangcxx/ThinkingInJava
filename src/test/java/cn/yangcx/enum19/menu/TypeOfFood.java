package cn.yangcx.enum19.menu;

/**
 * @author YANGCX
 * @date 2021/8/30 22:49
 */
public class TypeOfFood {

    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.HUMMOUS;
        food = Food.Dessert.CREME_CARAMEL;
        food = Food.Coffee.CAPPUCCINO;
    }

}
