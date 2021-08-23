package cn.yangcx.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author YANGCX
 * @date 2021/8/22 21:00
 */
public class TextFile extends ArrayList<String> {

    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            try (BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsolutePath()))) {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s).append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void write(String fileName, String text) {
        try {
            try (PrintWriter out = new PrintWriter(new File(fileName).getAbsolutePath())) {
                out.print(text);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        // Regular expression split() often leaves an empty String at the first position
        if (get(0).equals("")) {
            remove(0);
        }
    }

    /**
     * Normally read by lines
     */
    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            try (PrintWriter out = new PrintWriter(new File(fileName).getAbsolutePath())) {
                for (String item : this) {
                    out.println(item);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String path = "D:\\IdeaProjects\\ThinkingInJava\\src\\test\\java\\cn\\yangcx\\util\\TextFile.java";
        
        // String content = read(path);
        // write("test.txt", content);

        // TextFile text = new TextFile("test.txt");
        // text.write("test2.txt");

        TreeSet<String> words = new TreeSet<>(new TextFile(path, "\\W+"));
        System.out.println(words.headSet("a"));
    }

}
