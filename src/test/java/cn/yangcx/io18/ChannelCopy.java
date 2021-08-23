package cn.yangcx.io18;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author YANGCX
 * @date 2021/8/23 7:23
 */
public class ChannelCopy {

    public static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileInputStream(args[1]).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        while (in.read(buff) != -1) {
            // cxy Prepare for writing
            buff.flip();
            out.write(buff);
            // cxy Prepare for reading
            buff.clear();
        }
    }

}
