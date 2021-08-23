package cn.yangcx.io18;

import java.io.StringReader;

/**
 * @author YANGCX
 * @date 2021/8/22 17:44
 */
public class MemoryInput {

    public static void main(String[] args) throws Exception {
        StringReader in = new StringReader(BufferedInputFile.read("D:\\IdeaProjects\\ThinkingInJava\\src\\test\\java\\cn\\yangcx\\io18\\MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }

}
