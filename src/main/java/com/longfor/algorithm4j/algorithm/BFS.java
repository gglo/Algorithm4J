package com.longfor.demo.algorithm;


import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 从上到下打印每个二叉树的节点
 * <p>
 * 广度优先搜索
 *
 * @author wanggang
 */
public class BFS {

    /**
     * 广度优先搜索打印二叉树的每个节点
     * <p>
     * 采用辅助队列来实现
     *
     * @param root 根节点
     * @return 数组
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            arrayList.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        int[] intArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            intArr[i] = arrayList.get(i);
        }
        return intArr;
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
