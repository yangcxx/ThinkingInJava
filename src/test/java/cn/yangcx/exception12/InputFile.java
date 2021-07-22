package cn.yangcx.exception12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author YANGCX
 * @date 2021/7/13 8:00
 */
public class InputFile {

    private BufferedReader in;

    // 构造器中尽量抛出异常，避免误导使用者对象创建正常完成
    public InputFile(String fileName) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fileName));
            // other code might throw exception
        } catch (FileNotFoundException e) {
            System.out.println("Could not open " + fileName);
            // Wasn't open, so don't close it 此时文件还未打开，不需要关闭
            throw e;
        } catch (Exception e) {
            // All other exceptions must close it
            try {
                in.close();
            } catch (IOException e2) {
                System.out.println("in.close() unsuccessfully");
            }
            // Rethrow
            throw e;
        } finally {
            // Don't close it here!!! 文件应该在 InputFile 对象的整个生命周期内都处于打开状态
            System.out.println("Don't close it here!!!");
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("in.close() successfully");
        } catch (IOException e) {
            System.out.println("in.close() failed");
        }
    }

    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null) {
                    System.out.println("对文件的一些操作");
                }
            } catch (Exception e) {
                System.out.println("Caught exception in main()");
                e.printStackTrace(System.err);
            } finally {
                // todo 对于在构造阶段可能会抛出异常，并且要求清理的类，最安全的使用方式是使用嵌套的try-catch-finally子句
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile construction failed!");
        }
    }
}



