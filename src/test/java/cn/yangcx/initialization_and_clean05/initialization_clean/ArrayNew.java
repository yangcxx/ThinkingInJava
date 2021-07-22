package cn.yangcx.initialization_and_clean05.initialization_clean;

import java.util.Arrays;
import java.util.Random;

/**
 * @author YANGCX
 * @date 2021/5/18 6:58
 */
public class ArrayNew {

    public static void main(String[] args) {
        // cxy 尽量在定义时进行初始化
        String[] a;
        Random rand = new Random(47);
        // cxy 不能用new创建单个的基本类型数据  ==》 对应的时数组的长度
        //  基本数据类型值会自动初始化为空值（数字：0，布尔：false）
        a = new String[rand.nextInt(20)];
        System.out.println("length of a = " + a.length);
        System.err.println(Arrays.toString(a));
    }

}
