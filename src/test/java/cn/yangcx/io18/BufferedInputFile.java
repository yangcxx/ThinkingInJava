package cn.yangcx.io18;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author YANGCX
 * @date 2021/8/22 17:38
 */
public class BufferedInputFile {

    public static String read(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        // todo 需要手动添加换行符，readLine()删除了换行符
        while ((s = br.readLine()) != null) {
            sb.append(s).append(" \n");
        }
        br.close();
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.print(read("D:\\IdeaProjects\\ThinkingInJava\\src\\test\\java\\cn\\yangcx\\io18\\DirectoryDemo.java"));
    }

}
