package cn.yangcx.inner_class10;

/**
 * @author YANGCX
 * @date 2021/6/22 7:23
 */
public class DotNew {

    public class Inner {
    }

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        // todo 使用 .new 生成内部类对象
        //  非静态内部类创建必须依赖于外部类对象进行创建
        Inner inner = dn.new Inner();
        System.out.println(inner);

        // DotNew.Inner di = DotNew.new Inner();
    }

}
