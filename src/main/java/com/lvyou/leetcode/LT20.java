package com.lvyou.leetcode;

import java.util.Stack;

/**
 * @Author: VernLv
 * @Data: Create in 15:45 2019/8/5
 */
public class LT20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '{' || current == '['){
                stack.push(current);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                if (current == ')') {
                    if (stack.pop() != '(') {
                        return false;
                    }
                }
                if (current == '}') {
                    if (stack.pop() != '{') {
                        return false;
                    }
                }
                if (current == ']') {
                    if (stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return !stack.isEmpty();
    }
}
