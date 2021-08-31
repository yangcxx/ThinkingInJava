package cn.yangcx.enum19.oo;

import java.util.Random;

/**
 * 状态机：具有有限个特定的状态
 *
 * @author YANGCX
 * @date 2021/8/31 7:47
 */
public enum Input {

    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amount() { // Disallow
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP { // This must be the last instance.

        public int amount() { // Disallow
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    // In cents
    int value;

    Input(int value) {
        this.value = value;
    }

    Input() {
    }

    // In cents
    int amount() {
        return value;
    }

    static Random random = new Random(47);

    public static Input randomSelection() {
        // Don't include STOP:
        return values()[random.nextInt(values().length - 1)];
    }
}
