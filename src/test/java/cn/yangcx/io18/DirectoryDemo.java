package cn.yangcx.io18;

import cn.yangcx.util.Directory;
import cn.yangcx.util.PPrint;

import java.io.File;

import static cn.yangcx.util.Print.print;

/**
 * @author YANGCX
 * @date 2021/8/22 10:51
 */
public class DirectoryDemo {

    public static void main(String[] args) {
        // All directories
        PPrint.pprint(Directory.walk(".").dirs);
        // All files beginning with T
        for (File file : Directory.local(".", "T.*")) {
            print(file);
        }
        print("------------------");
        // All Java files beginning with T
        for (File file : Directory.walk(".", "T.*\\.java")) {
            print(file);
        }
        print("=========================");
        // Class files containing Z or z
        for (File file : Directory.walk(".", ".*[Zz].*\\.class")) {
            print(file);
        }
    }

}
