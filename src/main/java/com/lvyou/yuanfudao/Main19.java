package com.lvyou.yuanfudao;

import java.util.Stack;

/**
 * @author LeoLv
 * @date 2019/9/18 19:44
 */
public class Main19 {

    Stack<Integer> stack1 = new Stack<>();

    Stack<Integer> stack2 = new Stack<>();

    void add(int a) {

        stack1.push(a);
    }

    int poll() {

        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {

            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

        }
        return stack2.pop();
    }

}
