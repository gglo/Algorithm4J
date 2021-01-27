package com.longfor.demo.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口
 *
 * @author wanggang
 */
public class SlidingWindow {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 12};
        int[] result = maxSlidingWindow(arr, 2);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }


    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
