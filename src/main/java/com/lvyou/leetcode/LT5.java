package com.lvyou.leetcode;

/**
 * @Author: VernLv
 * @Data: Create in 10:11 2019/8/5
 */
public class LT5 {

    public static String longestPalindrome1(String s) {
        if ( null == s || s.length() == 0) {
            return s;
        }
        boolean[][] flag = new boolean[s.length()][s.length()];
        int start = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++){
            flag[i][i] = true;
            if(maxlength == 0){
                start = i;
                maxlength = 1;
            }
            if (i < s.length()-1 && s.charAt(i) == s.charAt(i+1)) {
                flag[i][i+1] = true;
                start = i;
                maxlength = 2;
            }
        }

        for (int i = 3; i <= s.length(); i++ ) {
            for (int j = 0; j <= s.length()-i; j++){
                int k = i + j - 1;
                if (flag[j+1][k-1] && s.charAt(j) == s.charAt(k)) {
                    flag[i][j] = true;
                    start = j;
                    maxlength = i;
                }
            }
        }
        return s.substring(start,start + maxlength);
    }
    public String longestPalindrome(String s) {
        if (null == s && 0 == s.length()) {
            return "";
        }
        int end = 0, start = 0;
        for (int i = 0;i < s.length(); i++){
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }

        return s.substring(start,end + 1);
    }

    private int expand(String s, int left, int right){
        while (left >= 0 && right < s.length() && left <= right && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome1("cbbd"));
    }
}
