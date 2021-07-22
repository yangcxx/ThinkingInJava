package cn.yangcx.interface09;

import java.util.Arrays;
import java.util.Locale;

/**
 * @author YANGCX
 * @date 2021/6/7 7:49
 */
public class Apply {

    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }

    public static final String s = "Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args) {
        process(new UpperCase(), s);
        process(new LowerCase(), s);
        process(new Splitter(), s);
    }

}

class Splitter extends Processor {
    @Override
    Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

class LowerCase extends Processor {
    @Override
    Object process(Object input) {
        return ((String) input).toLowerCase(Locale.CHINA);
    }
}

class UpperCase extends Processor {
    @Override
    Object process(Object input) {
        return ((String) input).toUpperCase(Locale.CHINA);
    }
}

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}
