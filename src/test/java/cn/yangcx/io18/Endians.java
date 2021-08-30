package cn.yangcx.io18;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/8/25 7:33
 */
public class Endians {

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        // todo 默认情况下就是高位优先
        bb.asCharBuffer().put("abcdef");
        print(Arrays.toString(bb.array()));
        bb.rewind();
        // 高位优先
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        print(Arrays.toString(bb.array()));
        bb.rewind();
        // 低位优先
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        print(Arrays.toString(bb.array()));
        bb.rewind();
    }

}
