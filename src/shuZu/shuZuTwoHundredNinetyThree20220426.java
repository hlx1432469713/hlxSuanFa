package shuZu;

/**
 *date：2022-04-26
 *
 * message :剑指 Offer 12. 矩阵中的路径
 *
 * work :给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 */
public class shuZuTwoHundredNinetyThree20220426 {
    public static void main(String[] args){}

    static boolean flag = false;
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(!flag && board[i][j] == word.charAt(0)){
                    dfs(board,i,j,0,word);
                }
            }
        }
        return flag;
    }
    public void dfs(char[][] board,int row,int col,int start,String word){
        int n = board.length;
        int m = board[0].length;
        if(row < 0 || row >= n || col < 0 || col >= m || flag || start >= word.length())
            return;
        if(board[row][col] != word.charAt(start) || board[row][col] == '#')
            return;
        board[row][col] = '#';
        if(start == word.length() - 1){
            flag = true;
            return;
        }
        dfs(board,row - 1,col,start + 1,word);
        dfs(board,row + 1,col,start + 1,word);
        dfs(board,row,col - 1,start + 1,word);
        dfs(board,row,col + 1,start + 1,word);
        board[row][col] = word.charAt(start);
    }
}
