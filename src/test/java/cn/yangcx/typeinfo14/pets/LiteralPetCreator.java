package cn.yangcx.typeinfo14.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 使用类字面常量
 *
 * @author YANGCX
 * @date 2021/7/21 7:24
 */
public class LiteralPetCreator extends PetCreator {

    // todo 不会触发对应类的初始化动作。如果新的类加入只能修改此处的代码
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(
            Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class, Pug.class, EgyptianMau.class,
            Manx.class, Cymric.class, Rat.class, Mouse.class, Hamster.class
    ));

    private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}
