package com.lvyou.yuanfudao;

/**
 * @author LeoLv
 * @date 2019/9/18 16:56
 */
public class Main4 {

    public static void main(String[] args) {
        int[] nums = {1,5,2,4,3,8};
        int ans = maxUnCon(nums);
        System.out.println(ans);
    }

    private static int maxUnCon(int[] nums) {

        int[] dp = new int[nums.length];

        dp[0] = 1;
        for (int i = 1;i < dp.length; i++){
            for (int j = i-1; j >= 0;j--) {

                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] +1);
                }
            }
        }
        return dp[dp.length-1];
    }
}
