package cn.yangcx.io18;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author YANGCX
 * @date 2021/8/22 20:48
 */
public class UsingRandomAccessFile {

    static String file = "rtest.txt";

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        // todo read 和 write 方法必须对应，否则可能出现错位
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i * 1.414);
        }
        rf.writeUTF("The end of file");
        rf.close();

        display();

        rf = new RandomAccessFile(file, "rw");
        // todo double是8字节，此处为查找第5个双精度值
        rf.seek(5 * 8);
        rf.writeDouble(47.0001);
        rf.close();

        display();
    }

}
