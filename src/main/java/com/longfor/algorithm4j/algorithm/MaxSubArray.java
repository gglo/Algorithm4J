package com.longfor.demo.algorithm;

/**
 * @author wanggang
 */
public class MaxSubArray {


    public static void main(String[] args) {

        int i = maxSubArray(new int[]{-1, 2, -9, 3});
        System.out.println(i);

    }

    /**
     * 子数组最大和
     * <p>
     * 1 状态定义
     * 2 转移方程
     * 3 初始化状态
     * 4 返回值
     *
     * @param nums
     * @return
     */
    public  static int maxSubArray(int[] nums) {
        int pre = nums[0];
        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(pre >= 0){
                pre = pre + nums[i];
            }else{
                pre = nums[i];
            }
            if(pre >= maxValue){
                maxValue = pre;
            }
        }
       return maxValue;

    }

}
