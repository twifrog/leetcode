package com.lvyou.leetcode;

/**
 * @Author: VernLv
 * @Data: Create in 10:38 2019/8/22
 */
public class LT162 {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (; left < right; ) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
