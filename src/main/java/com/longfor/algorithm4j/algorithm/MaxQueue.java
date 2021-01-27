package com.longfor.demo.algorithm;

import java.util.*;

/**
 * @author wanggang
 */
public class MaxQueue {



    private Queue<Integer> queue = null;
    private Deque<Integer> deque = null;


    public MaxQueue() {
        queue =  new LinkedList<>();
        deque = new ArrayDeque<>();
    }

    public int max_value() {
        if(queue.isEmpty()){
            return -1;
        }
        return deque.peek();
    }

    public void push_back(int value) {
        queue.add(value);
        while(!deque.isEmpty() && value > deque.getLast()){
            deque.pollLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        Integer poll = queue.poll();
        if(poll.equals(deque.peek())){
            deque.pop();
        }
        return poll;
    }
}
