package cn.yangcx.io18;

import java.nio.ByteBuffer;

import static cn.yangcx.util.Print.print;
import static cn.yangcx.util.Print.printnb;

/**
 * @author YANGCX
 * @date 2021/8/24 7:20
 */
public class GetData {

    public static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        // Allocate automatically zeroes the ByteBuffer
        int i = 0;
        // Returns this buffer's limit
        // 检测 limit 范围内的初始值，均为0
        while (i++ < bb.limit()) {
            if (bb.get() != 0) {
                print("nonzero");
            }
        }
        print("i = " + i);
        bb.rewind();

        // Store and read a char array
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0) {
            printnb(c + " ");
        }
        print();
        bb.rewind();

        // Store and read a short
        bb.asShortBuffer().put((short) 471142);
        print(bb.getShort());
        bb.rewind();

        // Store and read an int
        bb.asIntBuffer().put(99471142);
        print(bb.getInt());
        bb.rewind();

        // Store and read a long
        bb.asLongBuffer().put(99471142);
        print(bb.getLong());
        bb.rewind();

        // Store and read a float
        bb.asFloatBuffer().put(99471142);
        print(bb.getFloat());
        bb.rewind();

        // Store and read a double
        bb.asDoubleBuffer().put(99471142);
        print(bb.getDouble());
        bb.rewind();
    }

}
