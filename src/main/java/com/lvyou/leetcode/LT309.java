package com.lvyou.leetcode;

public class LT309 {

    public int maxProfit(int[] prices) {

        if ( null == prices || prices.length < 2){
            return 0;
        }

        //s0：没有股票第二天可以买  s1：持有股票  s2:没有股票第二天不能买（刚刚卖出）
        int s0 = 0, s1 = 0 - prices[0], s2 = 0;

        for (int i = 1; i < prices.length; i++){
            int pre0 = s0, pre1 = s1, pre2 = s2;
            s0 = Math.max(pre0,pre2);
            s1 = Math.max(s0-prices[i],pre1);
            s2 = pre1 + prices[i];
        }
        return Math.max(s0,s2);
    }
}
