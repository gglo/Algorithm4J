package com.longfor.algorithm4j.algorithm;

/**
 * @author wanggang
 */
public class DFS {


    public static void main(String[] args) {

        char[][] arr = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean agc = exist(arr, "ABCCED");
        System.out.println(agc);

    }


    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean b = deepFirstSearch(board, word.toCharArray(), i, j, 0);
                if(b){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先搜索
     *
     * @param board 矩阵信息
     * @param words 搜索的字符串信息
     * @param i     索引1
     * @param j     索引2
     * @param k     索引3
     */
    private static boolean deepFirstSearch(char[][] board, char[] words, int i, int j, int k) {

        if(i >= board.length || j >= board[0].length || i < 0 || j < 0 ||board[i][j] != words[k]){
            return false;
        }
        if(k == words.length - 1){
            return true;
        }

        board[i][j] = '\0';
        boolean res = deepFirstSearch(board, words, i -1, j, k+1) || deepFirstSearch(board, words, i  + 1, j, k+1)
                || deepFirstSearch(board, words, i , j - 1, k+1) || deepFirstSearch(board, words, i, j + 1, k+1);
        board[i][j] = words[k];
        return res;
    }
}
