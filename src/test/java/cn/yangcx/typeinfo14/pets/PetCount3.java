package cn.yangcx.typeinfo14.pets;

/**
 * @author YANGCX
 * @date 2021/7/22 9:48
 */
public class PetCount3 {

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            System.out.println(pet.getClass().getCanonicalName() + " ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }

}
