package com.txz.sixty.four;

/**
 * Created by Taxz on 2019/1/29/029.
 * GitHub:https://github.com/Taxz
 */
public class Solution {
    public static void main(String[] args) {
        int arr[][] = {{1,3,1},{1,5,1},{4,2,1}};
        //System.out.println( minPathSum(arr));
    }

    /*  采用循环方式
    public static int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int[][] distance = new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                int tmp = grid[i][j];
                if (i==0&&j==0)
                    distance[i][j] = tmp;
                else if (i == 0 && j != 0) {
                    distance[i][j] = tmp+distance[i][j - 1];
                }else if (i != 0 && j == 0) {
                    distance[i][j] = tmp+distance[i - 1][j];
                } else {
                    int min=distance[i - 1][j] > distance[i][j - 1] ? distance[i][j - 1] : distance[i - 1][j];
                    distance[i][j] = tmp + min;
                }

            }
        }
        return distance[grid.length-1][grid[0].length-1];
    }*/

    //递归方式
    private int[][]memo;
    private int m,n;
    private int res;

    public int minPathSum(int[][] grid) {
        m = grid.length;n = grid[0].length;
        memo = new int[m][n];
        return path(0,0,grid);
    }

    public int path(int i,int j,int[][] grid){
        if(i>=m || j>=n){
            return 10000;
        }
        if(memo[i][j] == 0){
            if(i==m-1 && j == n-1){
                return grid[i][j];
            }
            memo[i][j] =  Math.min(path(i+1,j,grid),path(i,j+1,grid))+grid[i][j];
        }
        return memo[i][j];
    }
}
