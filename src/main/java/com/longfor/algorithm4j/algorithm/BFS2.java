package com.longfor.algorithm4j.algorithm;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历二叉树的每个节点
 *
 * @author wanggang
 */
public class BFS2 {

    /**
     * 广度优先搜索打印二叉树的每个节点
     * <p>
     * 采用辅助队列来实现
     *
     * @param root 根节点
     * @return 数组
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(null == root){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<List<Integer>> intArr = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            // 长度
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(null == poll){
                    continue;
                }
                tmp.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            intArr.add(tmp);
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
