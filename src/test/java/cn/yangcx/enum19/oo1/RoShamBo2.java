package cn.yangcx.enum19.oo1;

import static cn.yangcx.enum19.oo1.Outcome.*;

/**
 * todo 两路分发：第一次通过方法调用实现；第二次通过 switch 实现
 *
 * @author YANGCX
 * @date 2021/9/1 22:44
 */
public enum RoShamBo2 implements Competitor<RoShamBo2> {

    /**
     * 这里的枚举相当于是定义了结果集
     */
    PAPER(DRAW, LOSE, WIN),
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, DRAW);

    private final Outcome vPAPER;
    private final Outcome vSCISSORS;
    private final Outcome vROCK;

    RoShamBo2(Outcome paper, Outcome scissors, Outcome rock) {
        this.vPAPER = paper;
        this.vSCISSORS = scissors;
        this.vROCK = rock;
    }

    public Outcome compete(RoShamBo2 it) {
        switch (it) {
            default:
            case PAPER:
                return vPAPER;
            case SCISSORS:
                return vSCISSORS;
            case ROCK:
                return vROCK;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
    }
}
