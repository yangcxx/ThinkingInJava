package cn.yangcx.string13;

import java.io.IOException;

/**
 * @author YANGCX
 * @date 2021/7/18 19:03
 */
public class Hex {

    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0) {
                result.append(String.format("%05x: ", n));
            }
            result.append(String.format("%02x ", b));
            n++;
            if (n % 16 == 0) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        // File file = new File("D:\\IdeaProjects\\ThinkingInJava\\src\\test\\java\\cn\\yangcx\\string13\\DatabaseException.java");
        // System.out.println(format(BinaryFile.read(file)));


        String s = "([-|\\\\+])?";
        System.err.println(s);

        System.out.println("\\");
    }

}
