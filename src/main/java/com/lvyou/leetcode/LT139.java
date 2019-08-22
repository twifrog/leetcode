package com.lvyou.leetcode;

import java.util.*;

/**
 * @Author: VernLv
 * @Data: Create in 9:23 2019/8/22
 */
public class LT139 {

    /**
     * 动态规划，dp[i]记录前i个字符是否能拆分，递推公式很好得到
     * */
    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }

    /**
     * 广度优先遍历 BFS
     * */
    private static String str;
    private static Set<Integer> cache;
    private static List<String> list;
    public static boolean wordBreakBFS(String s, List<String> wordList){

        str = s;
        cache = new HashSet<>();
        list = wordList;
        return BFS(0);
    }
    private static boolean BFS(int d){
        if (d == str.length()) {
            return true;
        }
        //剪枝
        if (cache.contains(d)){
            return false;
        }
        for (String word : list){
            if(str.startsWith(word, d)){
                if(BFS(d + word.length())){
                    return true;
                }
                cache.add( d + word.length());//已经为false的
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordBreak("leetcode",wordDict);
    }
}
