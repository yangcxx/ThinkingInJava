package cn.yangcx.io18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author YANGCX
 * @date 2021/8/23 6:52
 */
public class GetChannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        // Write file
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes(StandardCharsets.UTF_8)));
        fc.close();

        // Add to the end of the file
        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        // Move to the end
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes(StandardCharsets.UTF_8)));
        fc.close();

        // Read the file
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        // cxy
        buff.flip();
        while (buff.hasRemaining()) {
            System.out.print((char) buff.get());
        }
    }
}
