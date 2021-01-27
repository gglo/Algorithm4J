package com.longfor.demo.algorithm;

/**
 * @author wanggang
 * <p>
 * <p>
 * 动态规划 重复的子问题
 * <p>
 * 状态定义： 设 dpdp 为一维数组，其中 dp[i]dp[i] 的值代表斐波那契数列的第 ii 个数字。
 * 转移方程： dp[i + 1] = dp[i] + dp[i - 1]dp[i+1]=dp[i]+dp[i−1] ，即对应数列定义 f(n + 1) = f(n) + f(n - 1)f(n+1)=f(n)+f(n−1) ；
 * 初始状态： dp[0] = 1dp[0]=1, dp[1] = 1dp[1]=1 ，即初始化前两个数字；
 * 返回值： dp[n]dp[n] ，即斐波那契数列的第 nn 个数字。
 */
public class DPPlanning {

    public static void main(String[] args) {

        int i = numWays(
                3
        );
        System.out.println(i);

    }

    /**
     * 1 递归的方式
     *
     * @param n 台阶数
     * @return 个数
     */
    public static int numWays(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = dp[i - 1] + dp[i - 2];

            sum = sum % 1000000007;
            dp[i] = sum;
        }
        return dp[n];
    }
}
