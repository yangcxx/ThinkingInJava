package cn.yangcx.interface09.interfaceprocessor;

/**
 * @author YANGCX
 * @date 2021/6/8 7:10
 */
public class Waveform {

    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Waveform{" +
                "id=" + id +
                '}';
    }
}
