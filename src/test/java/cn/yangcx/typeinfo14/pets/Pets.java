package cn.yangcx.typeinfo14.pets;

import java.util.List;

/**
 * @author YANGCX
 * @date 2021/7/21 7:30
 */
public class Pets {

    // 提供了一种具体的 PetCreator 实现
    private static final PetCreator CREATOR = new LiteralPetCreator();

    public static Pet randomPet() {
        return CREATOR.randomPet();
    }

    public static Pet[] createArray(int size) {
        return CREATOR.createArray(size);
    }

    public static List<Pet> arrayList(int size) {
        return CREATOR.arrayList(size);
    }

    public static void main(String[] args) {
        PetCount.countPets(Pets.CREATOR);
    }

}
