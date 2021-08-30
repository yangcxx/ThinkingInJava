package cn.yangcx.enum19;

import java.util.EnumSet;

import static cn.yangcx.enum19.AlarmPoints.*;
import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/8/30 23:15
 */
public class EnumSets {
    public static void main(String[] args) {
        // 空集合
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(BATHROOM);
        print(points);
        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);
        points = EnumSet.allOf(AlarmPoints.class);
        print(points);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        print(points);
        points = EnumSet.complementOf(points);
        print(points);
    }
}

enum AlarmPoints {
    STAIR1, STAIR2, LOBBY, OFFICE1, OFFICE2, OFFICE3,
    OFFICE4, BATHROOM, UTILITY, KITCHEN;
}
