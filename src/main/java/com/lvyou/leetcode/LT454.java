package com.lvyou.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LT454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int ans = 0;
        HashMap<Integer,Integer> map1 = new HashMap<Integer, Integer>(A.length);
        HashMap<Integer,Integer> map2 = new HashMap<Integer, Integer>(A.length);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map1.put(sum,map1.getOrDefault(sum,0)+1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                map2.put(sum,map2.getOrDefault(sum,0)+1);
            }
        }
        for (Map.Entry entry1: map1.entrySet()){
            for (Map.Entry entry2: map2.entrySet()) {
                if ((Integer)entry1.getKey() + (Integer) entry2.getKey() == 0) {
                    ans += ((Integer)entry1.getValue()*(Integer)entry2.getValue());
                }
            }
        }
        return ans;
    }
}
