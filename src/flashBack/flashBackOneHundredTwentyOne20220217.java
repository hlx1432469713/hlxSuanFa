package flashBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-17
 *
 * message : 单词搜索
 *
 * work : 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；
 * 否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *

 */
public class flashBackOneHundredTwentyOne20220217 {
    public static void main(String args[]) {

    }

    static int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    //记忆化搜索
    //偏移量数组在二维平面内是经常使用的，可以把它的设置当做一个技巧，
    // 并且在这个问题中，偏移量数组内的 4 个偏移的顺序无关紧要；
    static public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row == 0)
            return false;
        int col = board[0].length;
        for (int i = 0;i < row;i++)
            for (int j = 0;j < col;j++){
                if (backtracking(board,i,j,0,word,new boolean[row][col]))
                    return true;
            }
        return false;
    }
    static public boolean backtracking(char[][] board, int x, int y,int index,String word,boolean[][] flag) {
        if (index == word.length() - 1)
            return board[x][y] == word.toCharArray()[index];
        if (board[x][y] == word.toCharArray()[index]){
            flag[x][y] = true;
            //上下左右---是否存在相等
            for (int[] i : DIRECTIONS){
                int newX = x + i[0];
                int newY = y + i[1];
                //新坐标是否越界
                if (newX >= 0 && newY >=0 && newX < board.length && newY < board[0].length){
                    //新坐标是否已经访问过
                    if (!flag[newX][newY]){
                        if (backtracking(board,newX,newY,index + 1,word,flag))
                            return true;
                    }
                }
            }
            flag[x][y] = false;
        }
        return false;
    }


}
