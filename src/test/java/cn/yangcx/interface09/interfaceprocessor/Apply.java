package cn.yangcx.interface09.interfaceprocessor;

/**
 * @author YANGCX
 * @date 2021/6/8 7:01
 */
public class Apply {

    public static void process(Processor p, Object input) {
        System.out.println("Using processor " + p.name());
        System.out.println(p.process(input));
    }

}
