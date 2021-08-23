package cn.yangcx.io18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author YANGCX
 * @date 2021/8/23 7:33
 */
public class BufferToText {

    public static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes(StandardCharsets.UTF_8)));
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        // 数据写入ByteBuffer
        fc.read(buff);
        // ByteBuffer转换为读模式（移动指针）
        buff.flip();
        // Doesn't work 乱码
        System.out.println(buff.asCharBuffer());

        // Decode using this system's default Charset
        // cxy
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        // 显示正常 todo 输出时解码
        System.out.println("Decoding using: " + encoding + ": " + Charset.forName(encoding).decode(buff));

        // Or, we could encode with something that will print
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes(StandardCharsets.UTF_16BE)));
        fc.close();

        // Now try reading again
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        // 显示正常 todo 输入时进行编码
        System.out.println(buff.asCharBuffer());

        // Use a CharBuff to write through
        fc = new FileOutputStream("data2.txt").getChannel();
        // More than needed
        // 一个字符需要2个字节，此ByteBuffer可容纳12个字符
        buff = ByteBuffer.allocate(24);
        // 写入字符仅为9
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();

        // Read and display
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        // todo 虽然内容没填满，内容为零的字符仍然被输出
        System.out.println(buff.asCharBuffer());
    }
}
