package com.pangypeng.chapter01.stackandqueue.subject01;

import java.util.Stack;

/**
 * Created by pang on 2016/4/2 0002.
 * 实现一个特殊的栈，在实现栈的基本功能上，再实现返回栈中最小元素的操作？
 *
 * 思路1：定义两个stack，一个用来存储进栈的数据stackData，一个用来存储当前栈中的最小值stackMin
 *  1、假设现在有一个newNum数据要进栈，先将newNum push入stackData
 *  2、判断stackMin是否为空，若是空的，则将newNum push入stakMin
 *  3、如果stackMin不为空，则去stackMin栈顶元素（设为sd）与newNum比较：
 *      a、newNum > sd ，只将newNum push 到stackData中
 *      b、newNum <= sd,则将newNum同时push到两个stack中。
 */
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    /**
     * 入栈
     * @param newNum
     */
    public void push(int newNum){

        if(stackMin.isEmpty()){// stackMin 为空
            stackMin.push(newNum);
        }else if(newNum <= getMin()){ // newNum小于等于stackMin栈顶元素
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if (stackMin.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int value = stackData.pop();
        if (value == getMin()){
            stackMin.pop();
        }
        return value;
    }

    /**
     * 去栈顶元素，且为最小元素
     * @return
     */
    public int getMin() {
        if(stackMin.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int value = stackMin.peek();// 取栈顶元素
        return value;
    }
}
