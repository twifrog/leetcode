package com.lvyou.leetcode;

import java.util.*;

public class LT18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {


        if(nums.length < 4 )
            return Collections.emptyList();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1])//去重
                continue;
            int newTarget = target-nums[i];//将四数之和转换为三数之和
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j]==nums[j-1])//去重
                    continue;
                int newTarget2 = newTarget-nums[j];//将三数之和转换为二数之和
                int l = j+1;
                int r = nums.length-1;
                while(l<r){
                    int sum = nums[l]+nums[r];
                    if(sum == newTarget2){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        ans.add(list);
                        while(l<r && nums[l]==nums[l+1]) l++;
                        while(l>r && nums[r]==nums[r-1]) r--;
                        l++;
                        r--;
                    }else if(sum < newTarget2){
                        while(l<r && nums[l]==nums[l+1]) l++;
                        l++;
                    }else{
                        while(l>r && nums[r]==nums[r-1]) r--;
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}

