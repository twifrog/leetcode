package com.lvyou.yuanfudao;

/**
 * @author LeoLv
 * @date 2019/9/18 21:19
 */
public class Main37 {

    public static void main(String[] args) {
        int[] nums = {1,1,3,3,4,5,5,5,5};
        int ans = midIndex(nums,8);
        System.out.println("finish");
    }

    public static int midIndex (int[] nums, int target) {

        int left = 0, right = nums.length -1;

        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == 0) {
                    return 0;
                } else if(nums[mid-1] != nums[mid]) {
                    return mid;
                } else {
                    right = mid-1;
                }
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
