package cn.yangcx.initialization_and_clean05.initialization_clean;

/**
 * @author YANGCX
 * @date 2021/5/14 8:04
 */
public class ArraysOfPrimitives {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;
        for (int i : a1) {
            System.out.println(i);
        }
        System.out.println();
        for (int i : a2) {
            System.out.println(i);
        }
    }

}
