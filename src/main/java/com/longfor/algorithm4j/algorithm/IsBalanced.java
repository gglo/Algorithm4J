package com.longfor.algorithm4j.algorithm;

/**
 * 一颗二叉树是不是一颗平衡二叉树
 *
 * @author wanggang
 */
public class IsBalanced {

    /**
     * 平衡二叉树的判断标准
     *
     * @param root 根节点
     * @return 结果
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
       return  Math.abs(maxDeep(root.left) - maxDeep(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    /**
     * 获取每个节点的深度
     *
     * @param root 根节点
     * @return 深度
     */
    private int maxDeep(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(maxDeep(root.left), maxDeep(root.right)) + 1;
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
