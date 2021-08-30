package cn.yangcx.enum19;

/**
 * @author YANGCX
 * @date 2021/8/30 22:04
 */
public class UpcastEnum {

    public static void main(String[] args) {
        Search[] values = Search.values();
        Enum<Search> e = Search.HITHER;
        // 通过 getEnumConstants 获取 Class 对象的所有 Enum 对象
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }

    }

}

enum Search {
    HITHER, YON
}
