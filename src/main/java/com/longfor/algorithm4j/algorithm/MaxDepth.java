package com.longfor.algorithm4j.algorithm;

/**
 * 获取二叉树的最大深度
 *
 * @author wanggang
 */
public class MaxDepth {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        int i = maxDepth(treeNode);
        System.out.println(i);

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 节点信息
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
