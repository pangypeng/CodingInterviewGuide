package com.pangypeng.chapter01.stackandqueue.subject05;

import java.util.Stack;

/**
 * Created by pang on 2016/4/6 0006.
 * 用一个栈实现另一个栈的排序
 * 思路：定义两个栈，分别为stackSort , stackHelp
 * 1、判断stackSort是否为空，不为空pop栈顶元素记为cur
 * 2、判断stackHelp是否为空，不为空则比较栈顶元素与cur的大小(为空直接push)
 * a、如果比cur大则将stackHelp栈顶元素pop并push到stackSort中，直到stackHelp栈顶元素小于cur
 * b、如果比cur小，则直接push到stackHelp中
 * 3、重复执行1 、 2 步直到stackSort为空
 */
public class SortStack {
    /**
     * 实现栈中元素从顶到底按从大到小顺序排列
     *
     * @param stackSort
     */
    public void formLargeToSmall(Stack<Integer> stackSort) {
        Stack<Integer> stackHelp = new Stack<>();
        while (!stackSort.isEmpty()) {
            int cur = stackSort.pop();
            while (!stackHelp.isEmpty() && stackHelp.peek() < cur) {
                stackSort.push(stackHelp.pop());
            }
            stackHelp.push(cur);
        }

        while (!stackHelp.isEmpty()) {
            stackSort.push(stackHelp.pop());
        }
    }

    /**
     * 从小到大
     * @param stackSort
     */
    public void formSmallToLarge(Stack<Integer> stackSort) {
        Stack<Integer> stackHelp = new Stack<>();
        while (!stackSort.isEmpty()) {
            int cur = stackSort.pop();
            while (!stackHelp.isEmpty() && stackHelp.peek() > cur){
                stackSort.push(stackHelp.pop());
            }
            stackHelp.push(cur);
        }
        while (!stackHelp.isEmpty()){
            stackSort.push(stackHelp.pop());
        }
    }

}
