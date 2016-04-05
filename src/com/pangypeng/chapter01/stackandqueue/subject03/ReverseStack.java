package com.pangypeng.chapter01.stackandqueue.subject03;

import java.util.Stack;

/**
 * Created by pang on 2016/4/5 0005.
 * 将一个栈中的元素作逆序排列，只允许使用递归函数，不能使用其他数据结构，不能使用辅助类
 * 思路：将栈中的元素逆序，即假设栈中的元素为3、2、1，逆序后为1、2、3
 *       1、找到栈底元素，并出栈
 *       2、递归执行第一步，当栈为空时，逆序将元素push
 */
public class ReverseStack {

    private Stack<Integer> stackReverse = null;

    public ReverseStack(){
        stackReverse = new Stack<>();
    }

    public void push(int pushInt){
        stackReverse.push(pushInt);
    }

    public int peek(){
        if (stackReverse.isEmpty()){
            throw new RuntimeException("空栈");
        }
        return stackReverse.peek();
    }

    /**
     * 得到栈底元素并移除
     * @return
     */
    private int getAndRemoveLastElement(){
        int result = stackReverse.pop();
        if(stackReverse.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLastElement();
            stackReverse.push(result);
            return last;
        }
    }

    /**
     * 将栈中的元素逆序
     */
    public void reverse(){
        if(stackReverse.isEmpty()){
            return;
        }
        int last = getAndRemoveLastElement();
        reverse();
        stackReverse.push(last);
    }
}
