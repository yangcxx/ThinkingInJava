package cn.yangcx.interface09.interfaceprocessor;

/**
 * <strong>适配器设计模式</strong>
 * @author YANGCX
 * @date 2021/6/8 7:07
 */
public class FilterAdapter implements Processor {

    private final Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        // cxy 接口 Processor 定义适配为 Filter 的定义
        return filter.process((Waveform) input);
    }
}
