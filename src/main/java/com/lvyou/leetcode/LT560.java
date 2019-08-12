package com.lvyou.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: VernLv
 * @Data: Create in 16:38 2019/8/12
 */
public class LT560 {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ret = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            ret += map.getOrDefault(sum - k,0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return ret;
    }
}
