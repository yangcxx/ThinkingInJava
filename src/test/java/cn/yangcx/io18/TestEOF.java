package cn.yangcx.io18;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author YANGCX
 * @date 2021/8/22 17:51
 */
public class TestEOF {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\IdeaProjects\\ThinkingInJava\\src\\test\\java\\cn\\yangcx\\io18\\TestEOF.java")));
        while (in.available() != 0) {
            System.out.print((char) in.readByte());
        }
    }

}
