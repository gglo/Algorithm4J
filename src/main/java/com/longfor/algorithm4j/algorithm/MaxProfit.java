package com.longfor.algorithm4j.algorithm;

/**
 * 股票的最大利润
 *
 * @author wanggang
 */
public class MaxProfit {

    public static void main(String[] args) {

        int[] arr = {7,1,5,3,6,4};
        int i = maxProfit(arr);
        System.out.println(i);


    }

    public static int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int[] arr = new int[prices.length];
        arr[0] = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            arr[i] = arr[i - 1] + (prices[i] - prices[i -1]);
            if(arr[i] <= 0){
                arr[i] = 0;
            }
            if(arr[i] >= max){
                max = arr[i];
            }
        }
        return max;
    }
}
