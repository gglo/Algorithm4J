package com.longfor.algorithm4j.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索求二叉树的路径和
 *
 * @author wanggang
 */
public class PathSum {


    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(8);
        integers.add(5);
        integers.add(3);
        integers.add(2);
        integers.add(8);
        integers.add(11);
        List<Integer> res = copyArr(integers);
        System.out.println(res);
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> arrayList = new ArrayList<>();
        recur(root, sum, new ArrayList<Integer>(), arrayList);
        return arrayList;
    }

    private static void recur(TreeNode root, int sum, List<Integer> list, List<List<Integer>> pathList) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum = sum - root.val;
        if (!isLeaf(root)) {
            if (root.left != null) {
                recur(root.left, sum, list, pathList);
            }
            if (root.right != null) {
                recur(root.right, sum, list, pathList);
            }
        } else {
            if (0 == sum) {
                pathList.add(copyArr(list));
            }
        }
        list.remove(list.lastIndexOf(root.val));
    }

    /**
     * 列表拷贝
     *
     * @param pathList 原始数据
     * @return
     */
    private static List<Integer> copyArr(List<Integer> pathList) {
        List<Integer> intList = new ArrayList<>();
        for (Integer integer : pathList) {
            intList.add(integer);
        }
        return intList;
    }

    private static boolean isLeaf(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        return left == null && right == null;
    }

    /**
     * 树节点信息
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
