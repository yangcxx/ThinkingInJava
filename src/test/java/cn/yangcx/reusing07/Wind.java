package cn.yangcx.reusing07;

/**
 * @author YANGCX
 * @date 2021/5/30 7:27
 */
public class Wind extends Instrument {

    public static void main(String[] args) {
        Wind flute = new Wind();
        // cxy “新类是现有类的一种类型”
        //  向上转型：将导出类（子类）引用转换为基类（父类）引用
        Instrument.tune(flute);
    }

}

class Instrument {
    public void play() {
        System.out.println("Instrument play");
    }

    static void tune(Instrument instrument) {
        instrument.play();
    }
}

