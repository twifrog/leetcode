package com.lvyou.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LT15 {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (null == nums || nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;

            while (left < nums.length && right < nums.length && left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> temp = new LinkedList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    ans.add(temp);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum > 0){
                    right--;
                } else if (sum < 0){
                    left++;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums).toString());
    }
}
