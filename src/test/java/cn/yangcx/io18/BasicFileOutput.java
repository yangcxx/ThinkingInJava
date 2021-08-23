package cn.yangcx.io18;

import java.io.*;

/**
 * @author YANGCX
 * @date 2021/8/22 17:55
 */
public class BasicFileOutput {

    static String file = "BasicFileOutput.out";

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("D:\\IdeaProjects\\ThinkingInJava\\src\\test\\java\\cn\\yangcx\\io18\\BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }

}
