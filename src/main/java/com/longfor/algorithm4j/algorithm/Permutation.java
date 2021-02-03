package com.longfor.algorithm4j.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * @author wanggang
 */
public class Permutation {


    public void main(String[] args) {

        String[] permutation = permutation("uag");
        for (String s : permutation) {
            System.out.println(s);
        }
    }

    static char[] c;

    public String[] permutation(String s) {
        List<String> res = new LinkedList<>();

        c = s.toCharArray();
        dfs(0, res);
        return res.toArray(new String[0]);

    }

    void dfs(int x, List<String> res) {
        if (x == c.length - 1) {
            // 添加排列方案
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            // 重复，因此剪枝
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            // 交换，将 c[i] 固定在第 x 位
            swap(i, x);
            // 开启固定第 x + 1 位字符
            dfs(x + 1, res);
            // 恢复交换
            swap(i, x);
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
