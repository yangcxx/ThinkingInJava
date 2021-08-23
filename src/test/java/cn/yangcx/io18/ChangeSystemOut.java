package cn.yangcx.io18;

import java.io.PrintWriter;

/**
 * @author YANGCX
 * @date 2021/8/22 21:34
 */
public class ChangeSystemOut {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello world!");
    }

}
