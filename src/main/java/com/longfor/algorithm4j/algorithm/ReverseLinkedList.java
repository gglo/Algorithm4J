package com.longfor.demo.algorithm;

/**
 * 翻转链表
 *
 * @author wanggang
 */
public class ReverseLinkedList {

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
        ListNode res = recurReverseList(listNode, null);
        System.out.println(res);
    }

    /**
     * 翻转链表
     * <p>
     * 使用双指针翻转链表
     *
     * @param head 头节点
     * @return 头节点
     */
    public static ListNode doublePointReverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }


    /**
     * 递归的方法 翻转链表
     *
     * @param cur 翻转之前头节点
     * @return 翻转之后头节点
     */
    private static ListNode recurReverseList(ListNode cur, ListNode pre) {
        if (null == cur) {
            return pre;
        }
        ListNode res = recurReverseList(cur.next, cur);
        // 回溯改变next指针的指向
        cur.next = pre;
        return res;
    }

    /**
     * 节点信息
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
