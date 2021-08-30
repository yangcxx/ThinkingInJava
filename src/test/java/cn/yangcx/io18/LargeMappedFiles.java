package cn.yangcx.io18;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import static cn.yangcx.util.Print.print;
import static cn.yangcx.util.Print.printnb;

/**
 * todo 内存映射文件允许我们创建和修改那些因为太大而不能放入内存的文件；可以假定整个文件都放在内存中，且完全可以将其当作非常大的数组来访问
 *
 * @author YANGCX
 * @date 2021/8/25 8:02
 */
public class LargeMappedFiles {

    /**
     * 128MB
     */
    static int length = 0x8FFFFFF;

    public static void main(String[] args) throws Exception {
        RandomAccessFile accessFile = new RandomAccessFile("test.dat", "rw");
        FileChannel channel = accessFile.getChannel();
        // cxy 指定了初始位置和映射区域长度，因此也可以映射某个大文件的部分内容
        MappedByteBuffer out = channel.map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }
        print("Finished writing");
        for (int i = length / 2; i < length / 2 + 6; i++) {
            printnb((char) out.get(i));
        }
    }

}
