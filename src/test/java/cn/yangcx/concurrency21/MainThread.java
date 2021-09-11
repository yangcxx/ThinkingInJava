package cn.yangcx.concurrency21;

/**
 * @author YANGCX
 * @date 2021/9/7 7:53
 */
public class MainThread {

    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }

}
