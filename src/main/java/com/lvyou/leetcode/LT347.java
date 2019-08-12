package com.lvyou.leetcode;

import java.util.*;

/**
 * @Author: VernLv
 * @Data: Create in 20:06 2019/8/9
 */
public class LT347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        Map.Entry<Integer,Integer>[] topk = new Map.Entry[k];
        for (int num: nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        return null;
    }

    private void heapfy(Map.Entry<Integer,Integer>[] entries,int i){
        int largest = i;
        int left = 2 * i + 1,right = 2 * i + 2;
        if (left < entries.length && entries[largest].getValue() < entries[left].getValue()){
            largest = left;
        }
        if (right < entries.length && entries[right].getValue() < entries[right].getValue()){
            largest = right;
        }
        if (largest != i) {
            Map.Entry temp = entries[i];
            entries[i] = entries[largest];
            entries[largest] = temp;
            heapfy(entries,largest);
        }
    }
}
