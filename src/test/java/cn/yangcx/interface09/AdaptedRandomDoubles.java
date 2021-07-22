package cn.yangcx.interface09;

import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * 适配器模式
 *
 * @author YANGCX
 * @date 2021/6/17 7:36
 */
public class AdaptedRandomDoubles extends RandomDoubles implements Readable {

    private int count;

    public AdaptedRandomDoubles(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0) {
            return -1;
        }
        String result = next() + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedRandomDoubles(7));
        while (s.hasNext()) {
            System.out.println(s.nextDouble() + " ");
        }
    }
}
