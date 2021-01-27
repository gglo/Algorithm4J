package com.longfor.algorithm4j.algorithm;

/**
 * 斐波那契公式推导
 *
 * @author wanggang
 */
public class Fib {

    /**
     * 使用递归的方式
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (1 == n) {
            return 1;
        }
        Integer[] arr = new Integer[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        return calculate(n, arr);
    }

    public int calculate(int n, Integer[] arr) {
        Integer fn = arr[n - 1];
        if (fn == null) {
            fn = calculate(n - 1, arr);
            arr[n - 1] = fn;
        }
        Integer fn2 = arr[n - 2];
        if (fn2 == null) {
            fn2 = calculate(n - 2, arr);
            arr[n - 2] = fn2;
        }
        return (fn + fn2) % 1000000007;
    }
}
