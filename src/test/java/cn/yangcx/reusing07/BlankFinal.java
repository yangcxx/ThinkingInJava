package cn.yangcx.reusing07;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author YANGCX
 * @date 2021/5/30 8:24
 */
public class BlankFinal {

    private final int i = 0;
    private final int j;

    private final Poppet poppet;

    public BlankFinal() {
        j = 1;
        poppet = new Poppet(1);
    }

    public BlankFinal(int x) {
        j = x;
        poppet = new Poppet(x);
    }

    public static void main(String[] args) {
        BlankFinal blankFinal1 = new BlankFinal();
        // final 域不能再被初始化
        // blankFinal1.poppet = new Poppet(2);
        new BlankFinal(47);
    }
}

@Data
@AllArgsConstructor
class Poppet {
    private int i;
}