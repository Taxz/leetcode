package com.txz.one.hundred.and.thirty;

/**
 * Created by Taxz on 2019/1/30/030.
 * GitHub:https://github.com/Taxz
 */
public class Solution {
    private int row;
    private int line;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        this.row = board.length - 1;
        this.line = board[0].length - 1;

        for (int i = 0; i <= row; i++) {
            diration(board, i, 0);
            diration(board, i, line);
        }
        for (int j = 0; j <= line; j++) {
            diration(board, 0, j);
            diration(board, row, j);
        }
        swap(board);
    }

    private void swap(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void diration(char[][] board, int i, int j) {
        if (i < 0 || i > row || j < 0 || j > line || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '-';
        diration(board, i, j + 1);
        diration(board, i + 1, j);
        diration(board, i, j - 1);
        diration(board, i - 1, j);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] arr = new char[][]{{'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}};
        solution.solve(arr);
        System.out.println(arr.toString());
    }

}
