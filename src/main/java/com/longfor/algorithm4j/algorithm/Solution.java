package com.longfor.algorithm4j.algorithm;

import java.util.Arrays;

/**
 * @author wanggang
 */
public class Solution {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        int[] ints = reversePrint(listNode);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }
    }


    /**
     * 数据扩容的问题
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {

        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 32) {
                builder.append("%20");
            } else {
                builder.append(chars[i]);
            }
        }
        return builder.toString();
    }

    /**
     * 链表翻转
     *
     * @param head 头节点
     * @return 值数据
     */
    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        // 计算链表的长度
        ListNode tmp = head;
        int length = 1;
        while (tmp.next != null) {
            length++;
            tmp = tmp.next;
        }
        int[] arr = new int[length];

        recur(head, arr, length);


        return arr;
    }

    private static void recur(ListNode next, int[] res, int index) {
        if (next == null) {
            return;
        }
        index--;
        recur(next.next, res, index);
        res[index] = next.val;
    }

    /**
     * 花园种花
     *
     * @param flowerbed 花园
     * @param n         花的个数
     * @return 返回花园信息
     */
    public static boolean canPlaceFlowers(Integer[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) {
                // 返回结果
                return true;
            }

            // 判断当前场地能不能种花
            // 条件1 当前啊位置为0
            if (flowerbed[i] == 1) {
                // 不能种花
                continue;
            }

            // 条件2 前一个位置为0
            if (i - 1 >= 0 && flowerbed[i - 1] == 1) {
                // 不能种花
                continue;
            }
            // 条件3 后一个位置为0
            if (i + 1 < flowerbed.length && flowerbed[i + 1] == 1) {
                // 不能种花
                continue;
            }
            // 可以种花
            flowerbed[i] = 1;
            n--;
        }
        System.out.println(n);
        System.out.println(Arrays.asList(flowerbed));

        return n <= 0;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
