package cn.yangcx.interface09.interfaceprocessor;

/**
 * @author YANGCX
 * @date 2021/6/8 6:59
 */
public interface Processor {

    String name();
    Object process(Object input);

}
