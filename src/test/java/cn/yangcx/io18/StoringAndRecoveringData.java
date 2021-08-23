package cn.yangcx.io18;

import java.io.*;

/**
 * @author YANGCX
 * @date 2021/8/22 18:07
 */
public class StoringAndRecoveringData {

    public static void main(String[] args) throws Exception {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
        out.writeDouble(Math.PI);
        // writeUTF() 使用 UTF-8 编码实现
        // todo writeUTF() & readUTF() 使用的是适合于Java的 UTF-8 变体，非Java程序需要特殊处理
        out.writeUTF("That was PI");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
        System.out.println(in.readDouble());
        // todo Only readUTF() will recover the Java-UTF String properly
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        in.close();
    }

}
