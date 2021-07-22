package cn.yangcx.interface09.interfaceprocessor;

/**
 * @author YANGCX
 * @date 2021/6/8 7:08
 */
public class Filter {

    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }

}
