package com.longfor.algorithm4j.algorithm;

/**
 * 判断一颗二叉树是不是对称的二叉树
 *
 * @author wanggang
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSymmetric2(root.left, root.right);
    }

    private boolean isSymmetric2(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return isSymmetric2(left.left, right.right) && isSymmetric2(left.right, right.left);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
