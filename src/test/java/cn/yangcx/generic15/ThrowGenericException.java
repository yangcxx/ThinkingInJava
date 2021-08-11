package cn.yangcx.generic15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/8/11 7:32
 */
public class ThrowGenericException {

    public static void main(String[] args) {
        ProcessRunner<String, Failure1> runner = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner.add(new Processor1());
        }
        try {
            System.out.println(runner.processAll());
        } catch (Failure1 e) {
            System.out.println(e);
        }

        ProcessRunner<Integer, Failure2> runner2 = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner2.add(new Processor2());
        }
        try {
            System.out.println(runner2.processAll());
        } catch (Failure2 e) {
            System.out.println(e);
        }
    }

}

interface Processor<T, E extends Exception> {
    void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
    private static final long serialVersionUID = -6236556782069465381L;

    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T, E> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure2 extends Exception {

    private static final long serialVersionUID = -3047708383211098369L;
}

class Processor2 implements Processor<Integer, Failure2> {
    static int count = 2;

    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        if (count-- > 1) {
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }
        if (count < 0) {
            throw new Failure2();
        }
    }
}

class Failure1 extends Exception {

    private static final long serialVersionUID = 3544577106021809516L;
}

class Processor1 implements Processor<String, Failure1> {
    static int count = 3;

    @Override
    public void process(List<String> resultCollector) throws Failure1 {
        if (count-- > 1) {
            resultCollector.add("help");
        } else {
            resultCollector.add("Ho!");
        }
        if (count < 0) {
            throw new Failure1();
        }
    }
}
