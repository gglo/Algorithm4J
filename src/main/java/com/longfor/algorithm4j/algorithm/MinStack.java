package com.longfor.demo.algorithm;

import java.util.Stack;

/**
 * @author wanggang
 */
public class MinStack {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(0);
        minStack.push(-1);
        minStack.push(-2);

        Integer min = minStack.min();
        System.out.println(min);

        Integer top = minStack.top();
        System.out.println(top);

        minStack.pop();

        Integer min1 = minStack.min();
        System.out.println(min1);

    }

    /**
     * 正常栈
     */
    private Stack<Integer> a_stack = null;

    /**
     * 辅助栈
     */
    private Stack<Integer> b_stack = null;

    public MinStack() {
        a_stack = new Stack<>();
        b_stack = new Stack<>();
    }

    /**
     * 压栈
     *
     * @param x 值
     */
    public void push(int x) {
        a_stack.push(x);

        // 如果b栈为空 或者 当前value <= b栈栈顶元素
        if (b_stack.isEmpty() || x <= b_stack.peek()) {
            b_stack.push(x);
        }
    }

    /**
     * 出栈 删除栈顶元素
     */
    public void pop() {
        Integer pop = a_stack.pop();

        // b栈不为空 且a栈弹出的元素等于b栈栈顶元素
        if (!b_stack.isEmpty() && b_stack.peek().equals(pop)) {
            b_stack.pop();
        }
    }

    public Integer top() {
        return a_stack.peek();
    }

    /**
     * 最小函数
     * <p>
     * 时间复杂度为O(1)
     *
     * @return 最小元素
     */
    public Integer min() {
        return b_stack.peek();
    }
}
