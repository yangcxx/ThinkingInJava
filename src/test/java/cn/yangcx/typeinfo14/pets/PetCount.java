package cn.yangcx.typeinfo14.pets;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author YANGCX
 * @date 2021/7/20 7:42
 */
public class PetCount {

    // 映射：字符串:计数
    private static class PetCounter extends HashMap<String, Integer> {
        private static final long serialVersionUID = -2493961734226063481L;

        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        Pet[] pets = creator.createArray(20);
        Arrays.asList(pets).forEach(pet -> {
            System.out.println(pet.getClass().getCanonicalName() + " ");
            counter.count("Pet");
            // todo 如果程序中使用了太多的 instanceof 表达式，只能说明程序设计不合理
            if (pet instanceof Dog) {
                counter.count("Dog");
            }
            if (pet instanceof Mutt) {
                counter.count("Mutt");
            }
            if (pet instanceof Pug) {
                counter.count("Pug");
            }
            if (pet instanceof Cat) {
                counter.count("Cat");
            }
            if (pet instanceof Manx) {
                counter.count("EgyptianMau");
            }
            if (pet instanceof Manx) {
                counter.count("Manx");
            }
            if (pet instanceof Manx) {
                counter.count("Cymric");
            }
            if (pet instanceof Rodent) {
                counter.count("Rodent");
            }
            if (pet instanceof Rat) {
                counter.count("Rat");
            }
            if (pet instanceof Mouse) {
                counter.count("Mouse");
            }
            if (pet instanceof Hamster) {
                counter.count("Hamster");
            }
        });
        System.out.println("<================================================================>");
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }

}
