package com.lvyou.yuanfudao;

import java.util.Stack;

/**
 * @author LeoLv
 * @date 2019/9/18 17:57
 */
public class Main15 {

    public static void main(String[] args) {
        int[] nums = {8, 2, 5, 4, 3, 9, 7, 2, 5};
        int[] ans = findNextBiger(nums);
        System.out.println("finish");

    }

    public static int[] findNextBiger (int[] nums) {

        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[nums.length];

        stack.push(0);

        int index = 1;

        while (index < nums.length) {
            if (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                ans[stack.peek()] = nums[index];
                stack.pop();
            }else {
                stack.push(index);
                index++;
            }
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }
}
