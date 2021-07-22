package cn.yangcx.polymorphism08;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author YANGCX
 * @date 2021/6/2 7:33
 */
public class Music {

    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] is) {
        for (Instrument i : is) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        Instrument[] orchestra = {new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind()};
        tuneAll(orchestra);
    }

}


class Instrument {
    void play(Note n) {
        System.out.println("Instrument's play() " + n);
    }

    String what() {
        return "Instrument";
    }

    void adjust() {
        System.out.println("Adjust Instrument");
    }
}

class Woodwind extends Wind {
    @Override
    void play(Note n) {
        System.out.println("Woodwind's play() " + n);
    }

    @Override
    String what() {
        return "Woodwind";
    }
}

class Brass extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Brass's play() " + n);
    }

    @Override
    String what() {
        return "Brass";
    }

    @Override
    void adjust() {
        System.out.println("Brass Instrument");
    }
}

class Stringed extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Stringed's play() " + n);
    }

    @Override
    String what() {
        return "Stringed";
    }

    @Override
    void adjust() {
        System.out.println("Stringed Instrument");
    }
}

class Percussion extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Percussion's play() " + n);
    }

    @Override
    String what() {
        return "Percussion";
    }

    @Override
    void adjust() {
        System.out.println("Percussion Instrument");
    }
}

class Wind extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Wind's play() " + n);
    }

    @Override
    String what() {
        return "Wind";
    }

    @Override
    void adjust() {
        System.out.println("Wind Instrument");
    }
}

@AllArgsConstructor
@Getter
enum Note {

    MIDDLE_C,

    ;

}
