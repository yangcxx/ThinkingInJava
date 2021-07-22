package cn.yangcx.initialization_and_clean05.initialization_clean;

import java.util.Arrays;
import java.util.Random;

/**
 * @author YANGCX
 * @date 2021/5/18 7:09
 */
public class ArrayClassObj {

    public static void main(String[] args) {
        Random rand = new Random(47);
        // cxy 引用数组
        Integer[] a = new Integer[rand.nextInt(20)];
        System.out.println("length of a = " + a.length);
        // 创建Integer对象并将其赋值给引用，初始化进程才算结束
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(500);
        }
        System.out.println(Arrays.toString(a));
    }

}
