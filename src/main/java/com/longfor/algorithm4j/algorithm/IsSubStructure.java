package com.longfor.demo.algorithm;

/**
 * 判断是不是二叉树的子树
 * <p>
 * 递归遍历 是不是他的子树 复杂度O(mn)
 *
 * @author wanggang
 */
public class IsSubStructure {


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }



        return (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     * 递推
     *
     * @param a a节点
     * @param b b节点
     * @return 是否是子节点
     */
    public boolean recur(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return recur(a.left, b.left) && recur(a.right, b.right);
    }


    /**
     * 树节点
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
