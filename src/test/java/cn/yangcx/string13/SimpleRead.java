package cn.yangcx.string13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

/**
 * @author YANGCX
 * @date 2021/7/18 21:49
 */
public class SimpleRead {

    public static BufferedReader br = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803"));

    public static void main(String[] args) {
        try {
            // 从控制台读取输入内容
            Scanner stdin = new Scanner(System.in);
            stdin.useDelimiter("\\s*,\\s*");
            System.out.println("What's your name?");
            // 只读取一行
            // String name = stdin.readLine();
            String name = stdin.nextLine();
            System.out.println(name);
            System.out.println("How old are you? What's your favorite double?");
            System.out.println("input: <age> <double>");
            // String numbers = stdin.readLine();
            String numbers = stdin.nextLine();
            System.out.println(numbers);
            String[] numArray = numbers.split(" ");
            int age = Integer.parseInt(numArray[0]);
            double favorite = Double.parseDouble(numArray[1]);
            System.out.format("Hi %s. \n", name);
            System.out.format("In 5 years you will be %d. \n", age + 5);
            System.out.format("My favorite double is %f. \n", favorite);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
