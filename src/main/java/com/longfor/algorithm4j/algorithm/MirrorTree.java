package com.longfor.demo.algorithm;

/**
 * 二叉树的翻转
 *
 * @author wanggang
 */
public class MirrorTree {

    /**
     * 采用递归的方式
     *
     * @param root 根节点
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    /**
     * treenode
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
