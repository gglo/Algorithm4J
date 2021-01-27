package com.longfor.dealgorithm4jmo.algorithm;

/**
 * @author wanggang
 */
public class MaxValueTest {
    public static void main(String[] args) {


    }

    public int maxValue(int[][] grid) {

        // 定义dp[]数据 x = m, y = n 代表她能拿到最大的礼物价值
        int[][] maxValue = new int[grid.length][grid[0].length];

        // 定义转移方程
        for (int i = 0; i < grid.length; i++) {
            int[] subGrid = grid[i];
            for (int i1 = 0; i1 < subGrid.length; i1++) {
                if (i == 0 && i1 == 0) {
                    maxValue[0][0] = grid[0][0];
                    continue;
                }
                if (i == 0) {
                    maxValue[i][i1] = maxValue[i][i1 - 1] + grid[i][i1];
                    continue;
                }
                if (i1 == 0) {
                    maxValue[i][i1] = maxValue[i - 1][i1] + grid[i][i1];
                    continue;
                }
                int temp1 = maxValue[i - 1][i1];
                int temp2 = maxValue[i][i1 - 1];
                if (temp1 >= temp2) {
                    maxValue[i][i1] = temp1 + grid[i][i1];
                } else {
                    maxValue[i][i1] = temp2 + grid[i][i1];
                }
            }
        }
        return maxValue[maxValue.length - 1][maxValue[0].length - 1];
    }
}
