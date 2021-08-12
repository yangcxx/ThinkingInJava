package cn.yangcx.array16;

import java.util.Arrays;
import java.util.Random;

/**
 * 多维数组
 *
 * @author YANGCX
 * @date 2021/8/11 22:43
 */
public class MultidimensionalPrimitiveArray {

    public static void main(String[] args) {
        // 二维数组定义
        int[][] twoDimension = {
                {1, 2, 3,},
                {4, 5, 6,}
        };
        // java.util.Arrays.deepToString(java.lang.Object[]) 可以用来打印多维数组
        System.out.println(Arrays.deepToString(twoDimension));

        String[][][] threeDimension = new String[2][3][4];
        threeDimension[0][0][0] = "000";
        threeDimension[0][0][1] = "001";
        threeDimension[0][0][2] = "002";
        threeDimension[0][0][3] = "003";

        threeDimension[0][1][0] = "010";
        threeDimension[0][1][1] = "011";
        threeDimension[0][1][2] = "012";
        threeDimension[0][1][3] = "013";

        threeDimension[0][2][0] = "020";
        threeDimension[0][2][1] = "021";
        threeDimension[0][2][2] = "022";
        threeDimension[0][2][3] = "023";

        threeDimension[1][0][0] = "100";
        threeDimension[1][0][1] = "101";
        threeDimension[1][0][2] = "102";
        threeDimension[1][0][3] = "103";

        threeDimension[1][1][0] = "110";
        threeDimension[1][1][1] = "111";
        threeDimension[1][1][2] = "112";
        threeDimension[1][1][3] = "113";

        threeDimension[1][2][0] = "120";
        threeDimension[1][2][1] = "121";
        threeDimension[1][2][2] = "122";
        threeDimension[1][2][3] = "123";
        System.err.println(Arrays.deepToString(threeDimension));

        Random random = new Random(47);
        int[][][] ints = new int[random.nextInt(7)][][];
        System.out.println(Arrays.deepToString(ints));
    }
}
