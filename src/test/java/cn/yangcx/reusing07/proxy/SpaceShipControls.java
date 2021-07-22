package cn.yangcx.reusing07.proxy;

/**
 * @author YANGCX
 * @date 2021/5/28 7:12
 */
public class SpaceShipControls {

    void up(int velocity) {
        System.out.println("up velocity: " + velocity);
    }

    void down(int velocity) {
        System.out.println("down velocity: " + velocity);
    }

    void left(int velocity) {
        System.out.println("left velocity: " + velocity);
    }

    void right(int velocity) {
        System.out.println("right velocity: " + velocity);
    }

    void forward(int velocity) {
        System.out.println("forward velocity: " + velocity);
    }

    void back(int velocity) {
        System.out.println("back velocity: " + velocity);
    }

    void turboBoost(int velocity) {
        System.out.println("turboBoost velocity: " + velocity);
    }

}
