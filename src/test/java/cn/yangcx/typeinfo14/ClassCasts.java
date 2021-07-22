package cn.yangcx.typeinfo14;

/**
 * @author YANGCX
 * @date 2021/7/19 22:51
 */
public class ClassCasts {

    public static void main(String[] args) {
        Building building = new House();
        Class<House> houseClass = House.class;
        // 类型转换
        House cast = houseClass.cast(building);
        House house = (House) building;
    }

}

class Building {

}

class House extends Building {

}
