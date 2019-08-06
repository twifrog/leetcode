package com.lvyou.leetcode;

/**
 * @Author: VernLv
 * @Data: Create in 17:16 2019/8/5
 */
public class LT53 {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (current < 0){
                current = nums[i];
            } else {
                current += nums[i];
            }
            max = Math.max(max,current);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ -2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
