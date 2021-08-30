package cn.yangcx.enum19.menu;

import cn.yangcx.util.Enums;

/**
 * todo "枚举的枚举"
 *
 * @author YANGCX
 * @date 2021/8/30 22:51
 */
public enum Course {

    APPETIZER(Food.Appetizer.class),
    MAIN_COURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private final Food[] values;

    Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }

}
