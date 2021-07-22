package cn.yangcx.string13;

import java.util.Random;

/**
 * @author YANGCX
 * @date 2021/7/16 7:06
 */
public class UsingStringBuilder {

    public static Random rand = new Random(47);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            sb.append(rand.nextInt(100));
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb);
    }
}
