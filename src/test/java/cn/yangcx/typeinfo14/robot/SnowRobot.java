package cn.yangcx.typeinfo14.robot;

import java.util.Arrays;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/7/22 11:48
 */
public class SnowRobot implements Robot {

    private String name;

    public SnowRobot(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowBot Series 11";
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    @Override
                    public String desc() {
                        return name + " can shovel snow";
                    }

                    @Override
                    public void cmd() {
                        System.out.println(name + " shoveling snow");
                    }
                },
                new Operation() {
                    @Override
                    public String desc() {
                        return name + " can chip ice";
                    }

                    @Override
                    public void cmd() {
                        System.out.println(name + " chipping ice");
                    }
                },
                new Operation() {
                    @Override
                    public String desc() {
                        return name + " can clear the root";
                    }

                    @Override
                    public void cmd() {
                        System.out.println(name + " clearing roof");
                    }
                });
    }

    public static void main(String[] args) {
        Robot.Test.test(new SnowRobot("Slusher"));
    }
}
