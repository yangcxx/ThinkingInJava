package cn.yangcx.io18;

import java.io.*;

/**
 * @author YANGCX
 * @date 2021/8/22 21:36
 */
public class Redirecting {

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        String path = "D:\\IdeaProjects\\ThinkingInJava\\src\\test\\java\\cn\\yangcx\\io18\\Redirecting.java";
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));

        // 重定向标准输入、标准输出、标准错误
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        out.close();

        System.setOut(console);
    }

}
