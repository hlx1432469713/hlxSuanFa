package flashBack;

import java.util.*;

/**
 *date：2022-03-18
 *
 * message ：51. N 皇后
 *
 * work :n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 即：每一行，每一列，每个左对角线，每个右对角线 都只能有一个皇后
 *
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 */
public class flashBackOneHundredSeventySeven20220318 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
          int n = scanner.nextInt();
            List<List<String>> listList = solveNQueens(n);
            for (List<String> list : listList) {
                for (String s : list) {
                    System.out.println(s );
                }
                System.out.println();
            }
        }
    }

    static List<List<String>> list = new ArrayList<>();
    static char[][] path ;
    static public List<List<String>> solveNQueens(int n) {
        path = new char[n][n];
        //模拟 n * n 空棋盘（还没有放皇后）
        for (char[] chars : path) {
            Arrays.fill(chars,'.');
        }
        backIng(n,0);
       return list;
    }

    /**
     *
     * @param n : 代表棋盘的宽度
     * @param row ：数组下标，从0开始，代表此次递归 已经到了第 row + 1行
     */
    static public void backIng(int n,int row) {
        //当row == n ，表面已经遍历完数组，代表形成了一个n皇后问题的解决方案
        if (row == n) {
            list.add(ToList(path));
        }
        for (int i = 0; i < n; i++) {
            //这里的循环代表着同一行的循环，每次都能在该行放置一个皇后
            //在每次递归前，先判断该位置是否 可以 放置 一个皇后，如果可以，将数组中该位置置为‘Q’
            if (isBoolean(row,i,n,path)) {
                path[row][i] = 'Q';
                backIng(n, row + 1);
                path[row][i] = '.';//该次循环结束，将该位置置为空，保证每一次循环，该行都能放置 一个皇后
            }
        }
    }

    /**
     * 不能同行
     * 不能同列（for循环已经能保证每次取一行中的一个）
     * 不能同斜线 （45度和135度角）
     * @param row
     * @param col
     * @param n
     * @param list
     * @return
     */
    static public boolean isBoolean(int row,int col,int n,char[][] list){
        //第一步检查列
        for (int i = 0;i < row;i++){
            if (list[i][col] == 'Q')
                return false;
        }
        //第二步检查左对角线
        for(int i = row - 1,j = col - 1;i >=0 && j >=0;i-- ,j--){
            if (list[i][j] == 'Q')
                return false;
        }
        //第三步检查右对角线
        for(int i = row - 1,j = col +1;i >=0 && j < n;i-- ,j++){
            if (list[i][j] == 'Q')
                return false;
        }
        return true;
    }
     static public List<String> ToList(char[][] list){
        List<String> result = new ArrayList<>();
         for (int i = 0; i < list.length; i++) {
             result.add(String.valueOf(list[i]));
         }
         return result;
    }

}
