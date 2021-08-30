package cn.yangcx.io18;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author YANGCX
 * @date 2021/8/24 7:36
 */
public class IntBufferDemo {

    public static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        // todo 视图缓冲器 ByteBuffer 依然是实际存储数据的地方，对视图的任何修改都会映射成为对 ByteBuffer 中数据的修改
        IntBuffer intBuffer = bb.asIntBuffer();
        // Store an array of int
        intBuffer.put(new int[]{11, 42, 47, 99, 143, 811, 1016});
        // Absolute location read and write
        System.out.println(intBuffer.get(3));

        intBuffer.put(3, 811);

        // Setting a new limit before rewinding the buffer
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            int i = intBuffer.get();
            System.out.println(i);
        }
    }

}
