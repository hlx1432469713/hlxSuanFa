package shuZu;

import java.util.Arrays;

/**
 *date：2022-04-27
 *
 * message :130. 被围绕的区域
 *
 * work :给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 */
public class shuZuTwoHundredNinetySix20220427 {
    public static void main(String[] args){
    }

    //使用boolean数组来作标记数组---用于记录  字符为’O‘但不能被替换的情况
    static  boolean[][] flag;
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        flag = new boolean[n][m];
        for(int i = 0;i < n;i++)
            Arrays.fill(flag[i],true);
        for(int i = 0;i < n;i++){
            if(board[i][0] == 'O' && flag[i][0] == true) {
                dfs(board,i,0,flag);
            }
        }
        for(int i = 1;i < m;i++){
            if(board[0][i] == 'O' && flag[0][i] == true) {
                dfs(board,0,i,flag);
            }
        }
        for(int i = 1;i < n;i++){
            if(board[i][m - 1] == 'O' && flag[i][m - 1] == true) {
                dfs(board,i,m - 1,flag);
            }
        }
        for(int i = 1;i < m;i++){
            if(board[n - 1][i] == 'O' && flag[n - 1][i] == true) {
                dfs(board,n - 1,i,flag);
            }
        }
        for(int i = 1;i < n - 1;i++)
            for (int j = 1;j < m - 1;j++){
                if (board[i][j] == 'O' && flag[i][j] == true)
                    board[i][j] = 'X';
            }
    }

    public void dfs(char[][] board ,int row,int col,boolean[][] flag){
        int n = board.length;
        int m = board[0].length;
        if(row < 0 || col < 0 || row >= n|| col >= m ||board[row][col] != 'O' || !flag[row][col])
            return;
        flag[row][col] = false;
        dfs(board,row - 1,col,flag);
        dfs(board,row + 1,col,flag);
        dfs(board,row ,col - 1,flag);
        dfs(board,row ,col + 1,flag);
    }

    //不使用额外数组，直接在board数组进行修改，只从四周边缘的’0‘开始遍历，遇到’O‘就将其置为’#‘
    // ,表示该位置虽然为’O‘，但是并没有被包围，所以不能置为’X‘。
         //最后在遍历全部，将’#‘ 置为’O‘ ，将’O‘置为’X‘
    public void solve2(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0;i < n;i++)
            for (int j = 0;j < m;j++){
                boolean flag = i == 0 || j == 0|| i == n - 1 || j == m - 1;
                if (board[i][j] == 'O' && flag)
                    dfs(board,i,j);
            }
        for(int i = 0;i < n;i++)
            for (int j = 0;j < m;j++){
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
    }

    public void dfs(char[][] board ,int row,int col){
        int n = board.length;
        int m = board[0].length;
        if(row < 0 || col < 0 || row >= n || col >= m || board[row][col] != 'O')
            return;
        board[row][col] = '#';
        dfs(board,row - 1,col);
        dfs(board,row + 1,col);
        dfs(board,row ,col - 1);
        dfs(board,row ,col + 1);
    }
}
