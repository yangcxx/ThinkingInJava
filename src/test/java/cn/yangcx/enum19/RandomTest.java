package cn.yangcx.enum19;

import cn.yangcx.util.Enums;

/**
 * @author YANGCX
 * @date 2021/8/30 22:17
 */
public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            System.out.println(Enums.random(Activity.class) + " ");
    }
}

enum Activity {
    SITTING, LYING, STANDING, HOPPING,
    RUNNING, DODGING, JUMPING, FALLING, FLYING
}
