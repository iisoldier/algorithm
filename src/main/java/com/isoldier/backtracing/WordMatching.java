package com.isoldier.backtracing;

/**
 * Author: jinmeng
 * Date: 2017-05-01
 * Time: 22:01
 *
 * Word Search 详见leetcode79
 */
public class WordMatching {
    public static void main(String[] args){

    }

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        //异或的目的是给匹配之后的字符串做个标记,不允许一个字符重复进行校验匹配
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        //将字符还原使得下次重新开始匹配的是原始的board
        board[y][x] ^= 256;
        return exist;
    }
}
