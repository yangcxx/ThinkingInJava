package cn.yangcx;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author YANGCX
 * @date 2021/7/25 15:43
 */
public class WordBreak {

    public static void main(String[] args) {
        Map<String, String> chn2Eng = new HashMap<>();
        chn2Eng.put("Yi", "One");
        chn2Eng.put("Er", "Two");
        chn2Eng.put("San", "San");
        chn2Eng.put("Si", "Four");
        chn2Eng.put("Wu", "Five");
        chn2Eng.put("Liu", "Six");
        chn2Eng.put("Qi", "Seven");
        chn2Eng.put("Ba", "Eight");
        chn2Eng.put("Jiu", "Nine");
        chn2Eng.put("Ling", "Zero");
        String input = "YiSanFiveWuQiJiuSi";
        boolean aBreak = wordBreak(input, chn2Eng.keySet());
        System.out.println(aBreak);
    }

    public static boolean wordBreak(String input, Set<String> dict) {
        if ("".equals(input) || input == null) {
            return false;
        }
        if (dict == null || dict.isEmpty()) {
            return false;
        }
        int len = input.length();
        Boolean[] dp = new Boolean[len + 1];
        dp[0] = true;
        //记录以XX结尾的字符串是否可分，动态规划
        for (int i = 1; i < input.length() + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String substring = input.substring(j, i);
                System.out.println("input.substring(" + j + ", " + i + ")==> " + input.substring(j, i));
                if (dp[j] && dict.contains(substring)) {
                    dp[i] = true;
                    break;
                } else {
                    dp[i] = false;
                }
            }
        }
        return dp[len];
    }

}
