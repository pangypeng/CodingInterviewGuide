package com.pangypeng.chapter01.stackandqueue.subject02;

import java.util.Stack;

/**
 * Created by pang on 2016/4/5 0005.
 * 编写一个类，用两个栈实现队列，支持队列的基本操作（add，poll，peek）
 *  add：将指定的元素插入队列
 *  poll获取并移除队列的头，如果队列为null，则返回null
 *  peek：获取但不移除队列的头，如果队列为空，则返回null
 *
 *  思路：
 *      栈的特点是先进后出，队列的特点是先进先出，刚好可以用两个栈把顺序倒过来实现队列的特点
 *      1、定义一个stackPush栈，一个stackPop栈
 *      2、将元素先push到stackPush栈中（相当于Queue的add操作），然后将stackPush栈中的元素全部倒入stackPop栈中
 *      3、再对stackPop栈执行pop（相当于Queue的poll操作）和peek操作（相当于Queue的peek操作）
 *
 *      注意：
 *          a、要将stackPush栈中的元素一次性全部倒入stackPop栈中
 *          b、在stackPop不为空时，不能将stackPush中的元素倒入
 *
 *      缺点：必须一次性把所有的元素push到stackPush栈中，如果后续向stackPush栈中添加元素则会抛出异常
 */
public class TwoStacksQueue {

    private Stack<Integer> stackPush = null;
    private Stack<Integer> stackPop = null;

    public TwoStacksQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    /**
     * 队列的add操作
     * @param pushInt
     */
    public void add(int pushInt){
        stackPush.push(pushInt);
    }

    /**
     * 队列的poll操作
     * @return
     */
    public int poll(){
        infunde();
        return stackPop.pop();
    }

    /**
     * 队列的peek操作
     * @return
     */
    public int peek(){
        infunde();
        return stackPop.peek();
    }

    /**
     * 将stackPush中的元素一次性全部倒入stackPop中
     */
    private void infunde(){
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("队列为空");
        }else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }else if (!stackPop.isEmpty()){
            throw new RuntimeException("队列不为空");
        }
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return stackPop.isEmpty();
    }

}
