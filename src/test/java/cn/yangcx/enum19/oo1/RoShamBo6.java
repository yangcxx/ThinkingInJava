package cn.yangcx.enum19.oo1;

import static cn.yangcx.enum19.oo1.Outcome.*;

/**
 * todo 两路分发效率最高的实现方式：二维数组
 *  完全基于 enum 的 ordinal() 方法获取定义顺序并预存比较结果
 *
 * @author YANGCX
 * @date 2021/9/1 23:26
 */
public enum RoShamBo6 implements Competitor<RoShamBo6> {

    PAPER, SCISSORS, ROCK;

    private static final Outcome[][] table = {
            // PAPER
            {DRAW, LOSE, WIN},
            // SCISSORS
            {WIN, DRAW, LOSE},
            // ROCK
            {LOSE, WIN, DRAW},
    };

    public Outcome compete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }
}
