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

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    /**
     * 定义前驱结点和头节点
     */
    private Node pre, head;

    /**
     * 将二叉搜索树转换为双向链表
     *
     * @param root 根节点信息
     * @return 双向链表
     */
    public static Node treeToDoublyList(Node root) {
        Node recur = recur(root);
        return recur;
    }

    /**
     * 先序遍历
     *
     * @param root
     */
    private static Node recur(Node root) {
        if (root == null) {
            return root;
        }
        // 左边节点处理
        Node pre = null;
        if (root.left != null) {
            pre = recur(root.left);
        }
        // 将当前的前置节点置为pre
        root.left = pre;
        pre = root;
        // 右边节点处理
        if (root.right != null) {
            Node right = recur(root.right);
            right.left = pre;
            pre = right;
        }
        return pre;
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
