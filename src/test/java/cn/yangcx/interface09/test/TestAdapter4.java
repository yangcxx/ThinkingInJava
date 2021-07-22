package cn.yangcx.interface09.test;

import cn.yangcx.interface09.interfaceprocessor.Processor;

/**
 * @author YANGCX
 * @date 2021/6/8 7:17
 */
public abstract class TestAdapter4 implements Processor {

    private final AdapterTest adapterTest;

    public TestAdapter4(AdapterTest adapterTest) {
        this.adapterTest = adapterTest;
    }

    @Override
    public Object process(Object input) {
        return this.adapterTest.m((String) input);
    }
}

class AdapterTest {
    String m(String s) {
        System.out.println("互换每一对字符");
        return s.toUpperCase();
    }
}
