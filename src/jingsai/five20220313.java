package jingsai;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 *date：2022-03-13
 *
 * message : 5203. 统计可以提取的工件
 *
 * work : 存在一个 n x n 大小、下标从 0 开始的网格，网格中埋着一些工件。给你一个整数 n 和一个下标从 0 开始的
 * 二维整数数组 artifacts ，artifacts 描述了矩形工件的位置，
 * 其中 artifacts[i] = [r1i, c1i, r2i, c2i] 表示第 i 个工件在子网格中的填埋情况：
 *
 * (r1i, c1i) 是第 i 个工件 左上 单元格的坐标，且
 * (r2i, c2i) 是第 i 个工件 右下 单元格的坐标。
 * 你将会挖掘网格中的一些单元格，并清除其中的填埋物。如果单元格中埋着工件的一部分，那么该工件这一部分将会裸露出来。
 * 如果一个工件的所有部分都都裸露出来，你就可以提取该工件。
 *
 * 给你一个下标从 0 开始的二维整数数组 dig ，其中 dig[i] = [ri, ci] 表示你将会挖掘单元格 (ri, ci) ，返回你可以提取的工件数目。
 *
 * 生成的测试用例满足：
 *
 * 不存在重叠的两个工件。
 * 每个工件最多只覆盖 4 个单元格。
 * dig 中的元素互不相同。
 *
 */
public class five20220313 {
    public static void main(String[] args) {

    }

    //用map来模拟
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Map<String,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0;i < dig.length;i++)
            map.put(dig[i][0] + "-" +dig[i][1],i);
        for(int i = 0;i <artifacts.length;i++ ){
            int[] artifact = artifacts[i];
            boolean flag = true;
            for(int j = artifact[0];j <= artifact[2];j++){
                for(int k = artifact[1];k <= artifact[3];k++){
                    if(!map.containsKey(j + "-" + k)) {
                        flag = false;
                        continue;
                    }
                }
            }
            if(flag)
                sum++;
        }
        return sum;
    }

    //用二维数组来模拟
    public int digArtifacts2(int n, int[][] artifacts, int[][] dig) {
        int[][] grid = new int[n][n];
        int sum = 0;
        for(int i = 0;i < dig.length;i++)
            grid[dig[i][0]][dig[i][1]] = 1;
        for(int i = 0;i <artifacts.length;i++ ){
            int[] artifact = artifacts[i];
            boolean flag = true;
            for(int j = artifact[0];j <= artifact[2];j++){
                for(int k = artifact[1];k <= artifact[3];k++){
                    if(grid[j][k] != 1) {
                        flag = false;
                        continue;
                    }
                }
            }
            if(flag)
                sum++;
        }
        return sum;
    }
}
