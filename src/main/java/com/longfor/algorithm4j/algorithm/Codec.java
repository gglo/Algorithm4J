package com.longfor.algorithm4j.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分别用来序列化和反序列化二叉树
 *
 * @author wanggang
 */
public class Codec {

    public static void main(String[] args) {

        /**
         *    1
         *    / \
         *   2   3
         *      / \
         *     4   5
         */
        TreeNode root = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        root.left = treeNode2;
        root.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        String serialize = serialize(root);
        System.out.println(serialize);

    }

    /**
     * 将key序列化成为一个字符串
     * <p>
     * 使用广度优先搜索
     *
     * @param root 根节点
     * @return 序列化之后的数据信息
     */
    public static String serialize(TreeNode root) {
        // 队列信息
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 结果列表
        List<Integer> arr = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode pollFirst = queue.pollFirst();
            if (pollFirst != null) {
                arr.add(pollFirst.val);
                queue.addLast(pollFirst.left);
                queue.addLast(pollFirst.right);
            } else {
                arr.add(null);
            }
        }
        return arr.toString();
    }

    /**
     * 反序列化
     */
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String[] valArr = data.substring(1, data.length() - 1).split(",");
        if (valArr.length <= 0) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点
        TreeNode root = new TreeNode(Integer.parseInt(valArr[0].trim()));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (!"null".equals(valArr[i])) {
                poll.left = new TreeNode(Integer.parseInt(valArr[i].trim()));
                queue.add(poll.left);
            }
            i++;
            if (!"null".equals(valArr[i])) {
                poll.right = new TreeNode(Integer.parseInt(valArr[i].trim()));
                queue.add(poll.right);

            }
            i++;
        }
        return root;
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
