package com.lvyou.leetcode;

import java.util.Arrays;

public class LT16 {

    public int threeSumClosest(int[] nums, int target) {
        if (null == nums || nums.length < 3) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length-3; i++){
            int left = i+1,right = nums.length-1;
            while (left < right) {
                int current = nums[i] + nums[left] + nums[right];
                if (current == target){
                    return target;
                }
                if (Math.abs(target-current) < Math.abs(target-ans)) {
                    ans = target;
                }
                if (current > target) {
                    right--;
                } else if (current < target){
                    left++;
                }

            }
        }
        return ans;
    }
}
