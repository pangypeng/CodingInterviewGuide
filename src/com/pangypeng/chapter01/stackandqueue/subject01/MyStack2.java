package com.pangypeng.chapter01.stackandqueue.subject01;

import java.util.Stack;

/**
 * Created by pang on 2016/4/2 0002.
 * 思路2：
 *  与思路1基本相同，只是在入栈有所不同
 *  1、假设有一个newNum数值要入栈
 *  2、判断stackMin是否为空
 *      a、如果为空则将newNum同时push到stackMin和stackData中
 *      b、如果不为空，则判断newNum与stackMin栈顶元素值（sd）的大小
 *          newNum > sd : 将newNum push到stackData中，将sd push 到 stackMin中
 *          newNum <= sd: 将newNum 同时push到两个stack中
 */
public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MyStack2(){
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    /**
     *
     * @param newNum
     */
    public void push(int newNum){
        if(stackMin.isEmpty()){
            stackMin.push(newNum);
        }else if(newNum <= getMin() ){
            stackMin.push(newNum);
        }else if(newNum > getMin()){
            stackMin.push(getMin());
        }
        stackData.push(newNum);
    }

    /**
     * 出栈，因为两个栈的元素个数是相同的，故一起出栈即可
     * @return
     */
    public int pop(){
        if(stackMin.isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stackData.pop();
        stackMin.pop();
        return value;
    }

    /**
     *
     * @return
     */
    public int getMin() {
        if(stackMin.isEmpty()){
            throw new RuntimeException("栈空");
        }
        return stackMin.peek();
    }
}
