package com.longfor.algorithm4j.algorithm;

/**
 * 将二叉搜索树转换为双向链表
 *
 * @author wanggang
 */
public class TreeToDoublyLinkedList {

    /**
     * 节点信息
     */
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 定义前驱结点和头节点
     */
    private static Node pre, head;

    /**
     * 将二叉搜索树转换为双向链表
     *
     * @param root 根节点信息
     * @return 双向链表
     */
    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        recur(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 先序遍历
     *
     * @param root
     */
    private static void recur(Node root) {
        if (root == null) {
            return;
        }
        // 左边节点处理
        recur(root.left);
        // 将当前的前置节点置为pre
        // 右边节点处理
        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = pre;
        pre = root;
        recur(root.right);
    }

    public static void main(String[] args) {
        // [4,2,5,1,3]
        Node node = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(1);
        Node node5 = new Node(3);

        node.left = node2;
        node.right = node3;

        node2.left = node4;
        node2.right = node5;

        Node res = treeToDoublyList(node);
        System.out.println(res);

    }
}
