package cn.yangcx.initialization_and_clean05.initialization_clean;

/**
 * @author YANGCX
 * @date 2021/5/18 7:22
 */
public class VarArgs {

    /**
     * 可变参数列表（必须放在参数最后一项）
     * cxy 由编译器完成填充数组的行为；调用方法时，可变参数长度可以为0
     *
     * @param args 可变参数
     */
    static void printArray2(Object... args) {
        System.out.println(args.length);
        for (Object arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

    static void printArray(Object[] args) {
        for (Object arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(new Object[]{47, 3.14f, 11.11});
        printArray(new Object[]{"one", "two", "three"});
        printArray(new Object[]{new A(), new A(), new A()});
    }


}

class A {
}
