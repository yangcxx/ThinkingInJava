package cn.yangcx.typeinfo14;

/**
 * @author YANGCX
 * @date 2021/7/19 22:42
 */
public class GenericToyTest {

    public static void main(String[] args) throws Exception {
        Class<FancyToy> fancyToyClass = FancyToy.class;
        // 可以直接获取到具体类型
        FancyToy fancyToy = fancyToyClass.getDeclaredConstructor().newInstance();
        Class<? super FancyToy> superClass = fancyToyClass.getSuperclass();
        // todo 只允许将超类声明为“某个类，是FancyToy的超类（非接口）”
        // Class<Toy> superclass2 = fancyToyClass.getSuperclass();
        // cxy 这里就只能是 Object 了
        Object object = superClass.getDeclaredConstructor().newInstance();
    }

}

class Toy{

}

class FancyToy extends Toy{

}
