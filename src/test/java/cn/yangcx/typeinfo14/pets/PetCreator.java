package cn.yangcx.typeinfo14.pets;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author YANGCX
 * @date 2021/7/20 7:28
 */
public abstract class PetCreator {

    private final Random rand = new Random(47);

    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet() {
        try {
            int i = rand.nextInt(types().size());
            return types().get(i).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size) {
        Pet[] ret = new Pet[size];
        for (int i = 0; i < size; i++) {
            ret[i] = randomPet();
        }
        return ret;
    }

    public List<Pet> arrayList(int size) {
        List<Pet> ret = new ArrayList<>();
        Collections.addAll(ret, createArray(size));
        return ret;
    }

}
