package cn.yangcx.exec_process;

import java.util.Arrays;

/**
 * 吸血鬼数字
 *
 * @author YANGCX
 * @date 2021/4/15 7:30
 */
public class VampireNumber {

    public static void main(String[] args) {
        getVampire1();
        // getVampire2();
    }

    /**
     * 官方答案
     */
    public static void getVampire2() {
        int calCount = 0;
        int[] startDigit = new int[4];
        int[] productDigit = new int[4];
        for (int i = 10; i < 100; i++) {
            for (int i1 = i; i1 < 100; i1++) {
                /*
                 * Pete Hartley's theoretical result:
                 * If x·y is a vampire number then
                 * x·y == x+y (mod 9)
                 */
                if ((i * i1) % 9 != (i + i1) % 9) {
                    continue;
                }
                int product = i * i1;
                startDigit[0] = i / 10;
                startDigit[1] = i % 10;
                startDigit[2] = i1 / 10;
                startDigit[3] = i1 % 10;

                productDigit[0] = product / 1000;
                productDigit[1] = (product % 1000) / 100;
                productDigit[2] = product % 1000 % 100 / 10;
                productDigit[3] = product % 1000 % 100 % 10;

                int count = 0;
                for (int i2 = 0; i2 < 4; i2++) {
                    for (int i3 = 0; i3 < 4; i3++) {
                        calCount++;
                        if (productDigit[i2] == startDigit[i3]) {
                            count++;
                            productDigit[i2] = -1;
                            startDigit[i3] = -2;
                            if (count == 4) {
                                System.out.println(i + " * " + i1 + " = " + product);
                            }
                        }
                    }
                }
            }
        }
        System.err.println("Final calCount = " + calCount);
    }

    public static void getVampire1() {
        int count = 0;
        for (int i = 10; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                int k = i * j;
                if (k <= 999 || k > 9999) {
                    continue;
                }
                count++;
                String[] str1 = String.valueOf(k).split("");
                String[] str2 = (String.valueOf(i) + j).split("");
                Arrays.sort(str1);
                Arrays.sort(str2);
                if (Arrays.equals(str1, str2)) {
                    System.out.println(i + " * " + j + " = " + k);
                }
            }
        }
        System.err.println("Finally count = " + count);
    }

}
