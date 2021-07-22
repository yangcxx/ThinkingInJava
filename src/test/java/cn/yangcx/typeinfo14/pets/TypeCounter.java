package cn.yangcx.typeinfo14.pets;

import java.util.HashMap;

/**
 * @author YANGCX
 * @date 2021/7/22 9:36
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {

    private final Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object obj) {
        Class<?> type = obj.getClass();
        // type 是否衍生于 baseType
        if (baseType.isAssignableFrom(type)) {
            countClass(type);
            return;
        }
        throw new RuntimeException(obj + " incorrect type: " + type + ", should be type or subtype of " + baseType);
    }

    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : (quantity + 1));
        Class<?> superclass = type.getSuperclass();
        if (superclass != null && baseType.isAssignableFrom(superclass)) {
            // 递归计数
            countClass(superclass);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (Entry<Class<?>, Integer> pair : entrySet()) {
            result.append(pair.getKey().getSimpleName())
                    .append("=")
                    .append(pair.getValue()).append(", ");
        }
        result.delete(result.length() - 1, result.length());
        result.append("}");
        return result.toString();
    }
}
