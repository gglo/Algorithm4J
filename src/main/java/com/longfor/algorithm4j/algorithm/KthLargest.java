package com.longfor.algorithm4j.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出二叉树中 第k大的元素信息
 *
 * @author wanggang
 */
public class KthLargest {


    public int kthLargest(TreeNode root, int k) {
        // 先将二叉树 使用深度优先中序遍历
        ArrayList<Integer> arrayList = new ArrayList<>();
        dfs(root, arrayList);
        if(arrayList.size() <= 0){
            return 0;
        }
        System.out.println(arrayList);
        return arrayList.get(k);

    }

    /**
     * 深度优先 实现二叉搜索树的中序遍历
     *
     * @param root 根节点
     * @param res  有序列表
     */
    private void dfs(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        TreeNode right = root.right;
        if (null != right) {
            dfs(right, res);
        }

        res.add(root.val);
        TreeNode left = root.left;
        if (left != null) {
            dfs(left, res);
        }

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
