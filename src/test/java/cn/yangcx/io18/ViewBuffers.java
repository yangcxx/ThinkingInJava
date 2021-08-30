package cn.yangcx.io18;

import java.nio.*;

import static cn.yangcx.util.Print.print;
import static cn.yangcx.util.Print.printnb;

/**
 * 存储数据的永远是底层的ByteBuffer，其他 *Buffer 都只是视图缓冲器（对视图缓冲器执行的操作都会映射到底层的 ByteBuffer 上）
 *
 * @author YANGCX
 * @date 2021/8/24 7:42
 */
public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
        bb.rewind();
        printnb("Byte Buffer ");
        while (bb.hasRemaining())
            printnb(bb.position() + " -> " + bb.get() + ", ");
        print();
        // CharBuffer
        bb.rewind();
        CharBuffer cb = bb.asCharBuffer();
        printnb("Char Buffer ");
        while (cb.hasRemaining())
            printnb(cb.position() + " -> " + cb.get() + ", ");
        print();
        // FloatBuffer
        bb.rewind();
        FloatBuffer fb = bb.asFloatBuffer();
        printnb("Float Buffer ");
        while (fb.hasRemaining())
            printnb(fb.position() + " -> " + fb.get() + ", ");
        print();
        // IntBuffer
        bb.rewind();
        IntBuffer ib = bb.asIntBuffer();
        printnb("Int Buffer ");
        while (ib.hasRemaining())
            printnb(ib.position() + " -> " + ib.get() + ", ");
        print();
        // LongBuffer
        bb.rewind();
        LongBuffer lb = bb.asLongBuffer();
        printnb("Long Buffer ");
        while (lb.hasRemaining())
            printnb(lb.position() + " -> " + lb.get() + ", ");
        print();
        // ShortBuffer
        bb.rewind();
        ShortBuffer sb = bb.asShortBuffer();
        printnb("Short Buffer ");
        while (sb.hasRemaining())
            printnb(sb.position() + " -> " + sb.get() + ", ");
        print();
        // DoubleBuffer
        bb.rewind();
        DoubleBuffer db = bb.asDoubleBuffer();
        printnb("Double Buffer ");
        while (db.hasRemaining())
            printnb(db.position() + " -> " + db.get() + ", ");
    }
}
