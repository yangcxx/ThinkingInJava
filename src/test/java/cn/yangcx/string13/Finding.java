package cn.yangcx.string13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author YANGCX
 * @date 2021/7/18 21:11
 */
public class Finding {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher("Eventing is full of the linnet's wings");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
        System.out.println();
        int i = 0;
        while (matcher.find(i)) {
            System.out.println(matcher.group() + " ");
            i++;
        }

        Pattern compile = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
    }

}
