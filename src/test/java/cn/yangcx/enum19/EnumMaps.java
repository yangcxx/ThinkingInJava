package cn.yangcx.enum19;

import java.util.EnumMap;
import java.util.Map;

import static cn.yangcx.enum19.AlarmPoints.*;
import static cn.yangcx.util.Print.print;
import static cn.yangcx.util.Print.printnb;

/**
 * @author YANGCX
 * @date 2021/8/30 23:27
 */
public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(KITCHEN, () -> print("Kitchen fire!"));
        em.put(BATHROOM, () -> print("Bathroom alert!"));
        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            printnb(e.getKey() + ": ");
            e.getValue().action();
        }
        try {
            // If there's no value for a particular key:
            em.get(UTILITY).action();
        } catch (Exception e) {
            print(e);
        }
    }

}

interface Command {
    void action();
}
