package com.longfor.demo.algorithm;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author wanggang
 */
public class CopyLinkedList {


    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node.next = node2;
        node.random = node8;



        node2.next = node3;
        node2.random = node;

        node3.next = node4;
        node3.random = node5;

        node4.next = node5;
        node4.random = node4;


        node5.next = node6;
        node5.random = node8;

        node6.next = node7;
        node6.random = node3;

        node7.next = node8;

        node8.next = node9;


        Node res = copyRandomList(node);
        System.out.println(res);

    }

    /**
     * 复杂链表的复制
     *
     * @param head 头节点
     * @return 复制链接结束之后的头节点
     */
    public static Node copyRandomList(Node head) {
        Node res = head;
        HashMap<Node, Node> map = new HashMap<Node, Node>(16);
        while (head != null) {
            // 当前节点
            Node copy = map.get(head);
            if (copy == null) {
                copy = new Node(head.val);
                map.put(head, copy);
            }

            if (head.next != null) {
                Node next = map.get(head.next);
                if (next == null) {
                    next = new Node(head.next.val);
                    map.put(head.next, next);
                }
                copy.next = next;
            }

            if (head.random != null) {
                Node random = map.get(head.random);
                if (random == null) {
                    random = new Node(head.random.val);
                    map.put(head.random, random);
                }
                copy.random = random;
            }

            // 指针刷新
            head = head.next;
        }
        return map.get(res);
    }

    /**
     * 节点
     */
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val &&
                    Objects.equals(next, node.next) &&
                    Objects.equals(random, node.random);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next, random);
        }
    }


}
