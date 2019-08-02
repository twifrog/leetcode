package com.lvyou.leetcode;

/**
 * @Author: VernLv
 * @Data: Create in 17:47 2019/8/2
 */
public class LT11 {

    public static int maxArea(int[] height) {
        if (null == height || height.length <= 1 ){
            return 0;
        }
        int volume = 0;
        int start = 0, end = height.length - 1;
        while (start < end){
            volume = Math.max(volume, (end - start) * Math.min(height[start],height[end]));
            if (height[start] < height[end]){
                start++;
            }else {
                end--;
            }
        }
        return volume;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
