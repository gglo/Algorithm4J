package com.longfor.algorithm4j.algorithm;

/**
 * 一颗二叉树是不是一颗平衡二叉树
 *
 * @author wanggang
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        return false;
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
