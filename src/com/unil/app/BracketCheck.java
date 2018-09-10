package com.unil.app;

import com.unil.element.Stack;
import com.unil.element.impl.ArrayStack;

/**
 * @author liuwh33
 * @date 2018/9/8 14:59
 * @desc
 */
public class BracketCheck {

    public static boolean check(String str) {
        Stack<Character> stringStack = new ArrayStack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stringStack.push(c);
            } else {
                if (c == ']' && stringStack.pop() != '[') {
                    return false;
                }
                if (c == '}' && stringStack.pop() != '{') {
                    return false;
                }
                if (c == ')' && stringStack.pop() != '(') {
                    return false;
                }
            }
        }
        return stringStack.isEmpty();
    }
}
