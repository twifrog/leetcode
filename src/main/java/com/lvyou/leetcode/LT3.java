package com.lvyou.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: VernLv
 * @Data: Create in 17:20 2019/8/2
 */
public class LT3 {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0){
            return 0;
        }

        Set<Character> set = new HashSet<Character>();
        int end = 0, start = 0, maxLength = 0;
        while (start < s.length() && end < s.length()) {
            if (set.contains(s.charAt(end))) {

                set.remove(s.charAt(start));
                start++;
            } else {
                set.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength, end - start );
            }

        }
        return maxLength;

    }

    public static void main(String[] args) {

    }
}
