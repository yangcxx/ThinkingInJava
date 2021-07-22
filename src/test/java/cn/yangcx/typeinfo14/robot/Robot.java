package cn.yangcx.typeinfo14.robot;

import cn.yangcx.util.Null;

import java.util.List;

/**
 * @author YANGCX
 * @date 2021/7/22 11:37
 */
public interface Robot {

    String name();

    String model();

    List<Operation> operations();

    class Test {
        public static void test(Robot robot) {
            if (robot instanceof Null) {
                System.out.println("[Null Robot]");
            }
            System.out.println("Robot name: " + robot.name());
            System.out.println("Robot model: " + robot.model());
            for (Operation operation : robot.operations()) {
                System.out.println(operation.desc());
                operation.cmd();
            }
        }
    }

}
