package com.lvyou.leetcode;

public class LT121 {
    public int maxProfit(int[] nums){

        if (nums == null){
            return 0;
        }
        int maxProfit = 0;
        int maxPrice = nums[nums.length-1];

        for (int i = nums.length - 1; i >= 0; i--) {
            maxPrice = Math.max(nums[i], maxPrice);
            maxProfit = Math.max(maxProfit,maxPrice - nums[i]);
        }
        return maxProfit;
    }
}
