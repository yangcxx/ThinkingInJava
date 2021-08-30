package cn.yangcx.enum19;

import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/8/30 21:36
 */
public class TrafficLight {

    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The Traffic Light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight tl = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            print(tl);
            tl.change();
        }
    }

}

enum Signal {
    GREEN, RED, YELLOW
}
