package com.longfor.algorithm4j.algorithm;


import java.util.HashSet;
import java.util.Set;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 解法1：深度优先搜索
 * 解法2： 广度优先搜索
 *
 * @author wanggang
 */
public class MovingCount {


    /**
     * 访问过的元素
     */
    Set<String> stepSet = new HashSet<>();
    /**
     * 定义元素的边界
     */
    int m , n, k;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        return dfs(0, 0, 0, 0);
    }

    /**
     * 深度优先搜索
     *
     * @param i  序号i
     * @param j  序号j
     * @param si 数位和i
     * @param sj 数位和j
     */
    private int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (si + sj > k) {
            return 0;
        }
        if (stepSet.contains(i + "-" + j)) {
            return 0;
        }
        stepSet.add(i + "-" + j);
        return 1 + dfs(i+1, j, sumsIJ(i, si), sj) + dfs(i, j + 1, si, sumsIJ(j, sj));
    }

    /**
     * 递推数位和
     *
     * @param i  序号
     * @param si 数位和
     * @return 数位和
     */
    private int sumsIJ(int i, int si) {
        if ((i + 1) % 10 == 0) {
            return si - 8;
        }
        return si + 1;
    }


}
