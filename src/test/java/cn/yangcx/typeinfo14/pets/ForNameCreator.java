package cn.yangcx.typeinfo14.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用 Class.forName(class_full_name)
 *
 * @author YANGCX
 * @date 2021/7/20 7:36
 */
public class ForNameCreator extends PetCreator {

    private static final List<Class<? extends Pet>> types = new ArrayList<>();

    private static final String[] typeNames = {
            // 必须是全类名
            "cn.yangcx.typeinfo14.pets.Mutt",
            "cn.yangcx.typeinfo14.pets.Pug",
            "cn.yangcx.typeinfo14.pets.EgyptianMau",
            "cn.yangcx.typeinfo14.pets.Cymric",
            "cn.yangcx.typeinfo14.pets.Rat",
            "cn.yangcx.typeinfo14.pets.Mouse",
            "cn.yangcx.typeinfo14.pets.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
