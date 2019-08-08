package com.lvyou.leetcode;

public class LT312 {

    public int maxCoins(int[] iNums) {
        if (null == iNums) {
            return 0;
        }

        int[] nums = new int[iNums.length+2];
        for (int i = 0; i < iNums.length; i++) {
            nums[i+1] = iNums[i];
        }
        nums[0] = nums[iNums.length+1] = 1;
        //dp记录从i 到 j 的最小得分
        int[][] dp = new int[iNums.length + 2][iNums.length + 2];

        for (int k = 1; k <= iNums.length; k++){
            for (int i = 1; i <= iNums.length - k + 1; i++) {
                int j = i + k - 1;
                for (int x = i; x <= j; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][x - 1] + nums[i - 1] * nums[x] * nums[j + 1] + dp[x + 1][j]);
                }
            }
        }
        return dp[1][iNums.length];
    }
}
