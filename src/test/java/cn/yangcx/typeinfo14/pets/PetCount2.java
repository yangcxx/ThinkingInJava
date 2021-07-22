package cn.yangcx.typeinfo14.pets;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用动态的 instanceof
 *
 * @author YANGCX
 * @date 2021/7/21 7:39
 */
public class PetCount2 {

    // 映射：Class:计数
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        private static final long serialVersionUID = 4290586144656314324L;

        public PetCounter() {
            // 预加载所有的类型
            LiteralPetCreator.allTypes.forEach(type -> put(type, 0));
        }

        public void count(Pet pet) {
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                Class<? extends Pet> clazz = pair.getKey();
                // 校验是否为目标Class
                if (clazz.isInstance(pet)) {
                    put(clazz, pair.getValue() + 1);
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("{");
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                result.append(pair.getKey().getSimpleName()).append("=").append(pair.getValue()).append(", ");
            }
            result.delete(result.length() - 2, result.length());
            result.append("}");
            return result.toString();
        }
    }

    public static void main(String[] args) {
        PetCounter counter = new PetCounter();
        Arrays.asList(Pets.createArray(20)).forEach(pet -> {
            System.out.println(pet.getClass().getCanonicalName() + " ");
            counter.count(pet);
        });
        System.out.println();
        System.out.println(counter);
    }

}
