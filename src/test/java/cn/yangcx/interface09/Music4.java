package cn.yangcx.interface09;

/**
 * @author YANGCX
 * @date 2021/6/7 6:59
 */
public class Music4 {
}

class Percussion extends Instrument {

    @Override
    public void play(Note n) {
        System.out.println("Percussion.play()");
    }

    @Override
    public void adjust() {
        System.out.println("Percussion.adjust()");
    }

    @Override
    public String what() {
        return "Percussion.what()";
    }
}

class Wind extends Instrument {

    @Override
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }

    @Override
    public void adjust() {
        System.out.println("Wind.adjust()");
    }

    @Override
    public String what() {
        return "Wind.what()";
    }
}

abstract class Instrument {

    private int i;

    public abstract void play(Note n);

    public String what() {
        return "Instrument";
    }

    public abstract void adjust();

}

enum Note {
    A, B, C
}
