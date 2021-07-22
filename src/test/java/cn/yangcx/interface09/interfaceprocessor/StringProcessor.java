package cn.yangcx.interface09.interfaceprocessor;

import java.util.Arrays;

/**
 * @author YANGCX
 * @date 2021/6/8 6:59
 */
public abstract class StringProcessor implements Processor {

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public abstract Object process(Object input);

    public static final String s = "If she weights the same as a duck, she's made of wood";

    public static void main(String[] args) {
        Apply.process(new UpperCase(), s);
        Apply.process(new LowerCase(), s);
        Apply.process(new Splitter(), s);
    }
}

class Splitter extends StringProcessor {
    @Override
    public Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

class UpperCase extends StringProcessor {
    @Override
    public Object process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class LowerCase extends StringProcessor {
    @Override
    public Object process(Object input) {
        return ((String) input).toLowerCase();
    }
}
