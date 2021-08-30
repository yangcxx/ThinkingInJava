package cn.yangcx.enum19;

/**
 * @author YANGCX
 * @date 2021/8/30 22:07
 */
public class NonEnum {

    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            for (Integer en : intClass.getEnumConstants()) {
                System.out.println(en);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
