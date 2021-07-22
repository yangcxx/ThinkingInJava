package cn.yangcx.reusing07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Random;

/**
 * @author YANGCX
 * @date 2021/5/30 8:01
 */
@AllArgsConstructor
@ToString
public class FinalData {

    private static Random rand = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    private final int valueOne = 9;
    public static final int VALUE_TWO = 99;
    public static final int VALUE_THREE = 39;

    private final int i4 = rand.nextInt(20);

    static final int INT_5 = rand.nextInt(20);

    private Value v1 = new Value(11);

    private final Value v2 = new Value(22);

    public static final Value VAL_3 = new Value(33);

    private final int[] a = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        FinalData finalData1 = new FinalData("finalData1");
        // cxy final 修饰的基本类型无法被更改
        // finalData1.valueOne++;

        // cxy final 修饰引用类型，只能保证指向的对象引用地址不变，无法保证对象本身不被改变
        finalData1.v2.i++;

        finalData1.v1 = new Value(9);

        // cxy final 修饰引用类型，只能保证指向的对象引用地址不变，无法保证对象本身不被改变
        for (int i = 0; i < finalData1.a.length; i++) {
            finalData1.a[i]++;
        }

        // cxy final 修饰的引用变量无法修改其引用
        // finalData1.v2 = new Value(0);
        // finalData1.VAL_3

        System.out.println(finalData1);
        System.out.println("Creating new FinalData");
        FinalData finalData2 = new FinalData("finalData2");
        System.out.println(finalData1);
        System.out.println(finalData2);
    }

}

@Data
@AllArgsConstructor
class Value {
    int i;
}
