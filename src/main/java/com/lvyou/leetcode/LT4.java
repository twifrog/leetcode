package com.lvyou.leetcode;

/**
 * @Author: VernLv
 * @Data: Create in 16:01 2019/8/5
 */
public class LT4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length == 0){
            return (nums2[(nums2.length-1)/2]+nums2[nums2.length/2])/2.0;
        }
        if (nums2.length == 0){
            return (nums1[(nums1.length-1)/2]+nums1[nums1.length/2])/2.0;
        }

        int length1 = nums1.length, length2 = nums2.length;

        //保证前面的数组是比较短的
        if (length1 > length2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low = 0, high = 2 * nums1.length;
        int C1 = 0, C2 = 0, L1 = 0, L2 = 0, R1 = 0, R2 = 0;

        while (low <= high) {

            C1 = (low + high) / 2;
            C2 = (nums1.length + nums2.length) - C1;

            if (C1 == 0){
                L1 = Integer.MIN_VALUE;
            } else {
                L1 = nums1[(C1 - 1) / 2];
            }
            if (C1 == 2 * nums1.length) {
                R1 = Integer.MAX_VALUE;
            } else {
                R1 = nums1[C1/2];
            }
            if (C2 == 0) {
                L2 = Integer.MIN_VALUE;
            } else {
                L2 = nums2[(C2 - 1) / 2];
            }
            if (C2 == 2 * nums2.length) {
                R2 = Integer.MAX_VALUE;
            } else {
                R2 = nums2[C2 / 2];
            }
            if (L1 > R2) {
                high = C1 - 1;
            }else if (L2 > R1){
                low = C1+1;
            }else {
                break;
            }

        }
        return (Math.max(L1,L2)+Math.min(R1,R2))/2.0;
    }
}
