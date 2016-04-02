package com.pangypeng;

import com.pangypeng.chapter01.stackandqueue.subject01.MyStack1;

public class Main {

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(3);
        myStack1.push(4);
        myStack1.push(5);
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(1);

        System.out.println("当前栈中的最小值为：" + myStack1.getMin());

    }
}
