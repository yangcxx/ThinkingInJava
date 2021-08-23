package cn.yangcx.io18;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * cn.yangcx.io18.BasicFileOutput 的优化版本
 *
 * @author YANGCX
 * @date 2021/8/22 18:01
 */
public class FileOutputShortcut {

    static String file = "FileOutputShortcut.out";

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("D:\\IdeaProjects\\ThinkingInJava\\src\\test\\java\\cn\\yangcx\\io18\\FileOutputShortcut.java")));
        // todo 相比 cn.yangcx.io18.BasicFileOutput.java 节省了一部分装饰工作
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }

}
