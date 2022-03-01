import java.util.Scanner;

/**
 *date：2022-02-23
 *
 * message :  球会落何处
 *
 * work :用一个大小为 m x n 的二维网格 grid 表示一个箱子。
 * 你有 n 颗球。箱子的顶部和底部都是开着的。
 *
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 *
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。
 * 如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 *
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 *
 */
public class DynamicOneHundredThirtyThree20220224 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] num = new int[m][n];
            for (int i = 0;i < m;i++)
                for (int j = 0;j < n;j++)
                    num[i][j] = scanner.nextInt();
            int[] flag  = findBall(num);
            for (int i : flag)
                System.out.print(i + " ");
        }
    }

    static public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] num = new int[n];
        for (int i = 0;i <n;i++){
            int n1 = i;
            int m1 = 0;
            while(m1 >=0 && m1 < m && n1 >= 0  && n1 < n){
                if (grid[m1][n1] == 1){
                    if (n1 == n - 1 || grid[m1][n1 + 1] == -1) {
                        break;
                    }else {
                        n1++;
                        m1++;
                    }
                }else if (grid[m1][n1] == -1){
                    if (n1 == 0 || grid[m1][n1 - 1] == 1) {
                        break;
                    }else {
                        n1--;
                        m1++;
                    }
                }
            }
            if (m1 >= m)
                num[i] = n1;
            else
                num[i] = -1;
        }
        return num;
    }

}
