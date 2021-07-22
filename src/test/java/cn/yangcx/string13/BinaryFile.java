package cn.yangcx.string13;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author YANGCX
 * @date 2021/7/18 19:10
 */
public class BinaryFile {


    public static byte[] read(File file) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            byte[] data = new byte[bis.available()];
            bis.read(data);
            return data;
        }
    }
}
