package cn.yangcx.typeinfo14.robot;

import cn.yangcx.util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/7/23 7:07
 */
public class NullRobot {

    // 生成一个满足规则的Null对象
    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),
                new Class[]{Null.class, Robot.class},
                new NullRobotInvocationHandler(type));
    }

    public static void main(String[] args) {
        Robot[] bots = {new SnowRobot("SnowBee"), NullRobot.newNullRobot(SnowRobot.class)};
        for (Robot bot : bots) {
            Robot.Test.test(bot);
        }
    }

}

/**
 * 动态代理类：生成 Robot 的空对象
 */
class NullRobotInvocationHandler implements InvocationHandler {
    private final String nullName;
    private final Robot proxied = new NRobot();

    public NullRobotInvocationHandler(Class<? extends Robot> type) {
        this.nullName = type.getSimpleName() + " NullRobot";
    }

    private class NRobot implements Null, Robot {

        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }
}
