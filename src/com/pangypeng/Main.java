package com.pangypeng;

import com.pangypeng.chapter01.stackandqueue.subject05.SortStack;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);

        SortStack sortStack = new SortStack();
//        sortStack.formLargeToSmall(stack);
        sortStack.formSmallToLarge(stack);
        System.out.println(stack.peek());
    }
}
