package com.lvyou.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: VernLv
 * @Data: Create in 16:41 2019/8/2
 */
public class LT3 {

    public static int lengthOfLongestSubstring(String s) {

        if (null == s || 0 == s.length()){
            return 0;
        }

        int max = 0, start = 0, end = 0;
        Set<Character> set = new HashSet<Character>();
        while(start < s.length() && end < s.length()){
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }else {
                end++;
                set.add(s.charAt(end));
                max = Math.max(end - start, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abc"));
    }
}
