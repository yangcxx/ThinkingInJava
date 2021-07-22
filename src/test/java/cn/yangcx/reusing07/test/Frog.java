package cn.yangcx.reusing07.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author YANGCX
 * @date 2021/5/30 7:47
 */
public class Frog extends Amphibian {

    public Frog(String insect) {
        super(insect);
    }

    @Override
    void song() {
        System.out.println("Frog override Amphibian's song method");
        super.song();
    }

    public static void main(String[] args) {
        Frog frog = new Frog("this is a export-class");
        Amphibian.eat(frog);
        frog.song();
    }

}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Amphibian {

    private String insect;

    static void eat(Amphibian amphibian) {
        System.out.println("Amphibian eat " + amphibian.getInsect());
    }

    void song() {
        System.out.println("Amphibian song method");
    }

}
