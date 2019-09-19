package com.lvyou.yuanfudao;

/**
 * @author LeoLv
 * @date 2019/9/18 16:48
 */
public class Main3 {

    public static void main(String[] args) {
        int[] nums = {1,5,2,4,3,8};
        int ans = maxinc(nums);
        System.out.println(ans);
    }

    private static int maxinc (int[] nums) {

        int max = 1;
        int current = 1;

        for (int i = 1; i <nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                current++;
                max = Math.max(current,max);
            }else {
                current = 1;
            }
        }
        return max;
    }
}
