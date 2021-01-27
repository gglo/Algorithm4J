package com.longfor.algorithm4j.algorithm;

import java.util.Stack;

/**
 * @author wanggang
 */
public class CQueue {

    private Stack<Integer> append = null;
    private Stack<Integer> delete = null;

    public CQueue() {
        append = new Stack<Integer>();
        delete = new Stack<Integer>();
    }

    /**
     * 头部添加
     *
     * @param value 值
     */
    public void appendTail(int value) {
        append.push(value);
    }

    /**
     * 尾部删除
     *
     * @return 尾部元素
     */
    public int deleteHead() {
        if (!delete.isEmpty()) {
            return delete.pop();
        }
        if (append.isEmpty()) {
            return -1;
        }
        while (!append.isEmpty()) {
            delete.push(append.pop());
        }
        return delete.pop();
    }
}
