package com.longfor.algorithm4j.algorithm;

/**
 * 字符串截取
 *
 * @author wanggang
 */
public class ReverseWord {

    public static void main(String[] args) {
        String res = reverseLeftWords("uqwnvde", 2);
        System.out.println(res);

    }

    /**
     * 将左侧字符截取n位放在右侧
     *
     * @param s 待操作字符串
     * @param n 位数
     * @return 结果
     */
    public static String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        // 子字符
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < chars.length; i++) {
            builder.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            builder.append(chars[i]);
        }
        return builder.toString();
    }
}
