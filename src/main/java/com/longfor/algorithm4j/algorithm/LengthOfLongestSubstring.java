package com.longfor.demo.algorithm;

import java.util.HashMap;

/**
 * @author wanggang
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        int lengthOfLongestSubstring = lengthOfLongestSubstring("uiidfnnnfydyseragdafasfdfagczvweq");
        System.out.println(lengthOfLongestSubstring);

    }


    /**
     * 动态规划解最长子字符串
     *
     * @param s 目标字符串
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        Integer[] res = new Integer[s.length()];
        res[0] = 1;
        int max = 1;
        HashMap<Character, Integer> integerHashMap = new HashMap<Character, Integer>(16);
        char[] chars = s.toCharArray();
        integerHashMap.put(chars[0], 0);
        for (int i = 1; i < chars.length; i++) {
            char aChar = chars[i];
            Integer j = integerHashMap.get(aChar);
            integerHashMap.put(aChar, i);
            if (j == null) {
                res[i] = res[i - 1] + 1;
            } else if (res[i - 1] < i - j) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = i - j;
            }

            // 获取最大值
            if (max <= res[i]) {
                max = res[i];
            }
        }
        return max;
    }
}
