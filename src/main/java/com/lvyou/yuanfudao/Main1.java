package com.lvyou.yuanfudao;

import java.util.Stack;

/**
 * @author LeoLv
 * @date 2019/9/18 16:27
 */
public class Main1 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(3);

        stack.push(2);
        stack.push(10);

        Stack result = stackSort(stack);

        System.out.println("finish");
    }


    private static Stack<Integer> stackSort(Stack<Integer> stack) {


        Stack<Integer> result = new Stack<Integer>();

        if (stack.isEmpty() || stack.size() == 1) {
            return stack;
        }
        int temp = stack.pop();

        while ( !stack.isEmpty() ||  result.peek() < temp) {

            if (result.isEmpty() || result.peek() >= temp) {
                result.push(temp);
                temp = stack.pop();

            } else {
                stack.push(result.pop());
            }
        }
        result.push(temp);
        return result;

    }
}
