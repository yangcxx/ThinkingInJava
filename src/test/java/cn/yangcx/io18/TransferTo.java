package cn.yangcx.io18;

import java.io.FileInputStream;
import java.nio.channels.FileChannel;

/**
 * @author YANGCX
 * @date 2021/8/23 7:29
 */
public class TransferTo {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileInputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
        // Or
        // out.transferFrom(in,0,in.size());
    }

}
