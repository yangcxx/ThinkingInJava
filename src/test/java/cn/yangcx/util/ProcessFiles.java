package cn.yangcx.util;

import java.io.File;
import java.io.IOException;

/**
 * @author YANGCX
 * @date 2021/8/22 10:56
 */
public class ProcessFiles {

    /**
     * 策略
     */
    public interface Strategy {
        void process(File file);
    }

    private final Strategy strategy;
    private final String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg);
                    } else {
                        // Allow user to leave off extension
                        if (!arg.startsWith("." + ext)) {
                            arg += "." + ext;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processDirectoryTree(File root) throws IOException {
        Directory.TreeInfo treeInfo = Directory.walk(root.getAbsolutePath(), ".*\\." + ext);
        for (File file : treeInfo) {
            strategy.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        // 根据参数策略进行对应的处理
        new ProcessFiles(System.out::println, "java").start(args);
    }

}
