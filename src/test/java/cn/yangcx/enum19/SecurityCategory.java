package cn.yangcx.enum19;

import cn.yangcx.util.Enums;

/**
 * @author YANGCX
 * @date 2021/8/30 22:56
 */
public enum SecurityCategory {

    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);

    Security[] values;

    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }

    /**
     * 将枚举组合为一个公共类型
     */
    interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGIN;
        }

        enum Bond implements Security {
            MUNICIPAL, JUNK
        }
    }

    public Security randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": " + category.randomSelection());
        }
    }
}
