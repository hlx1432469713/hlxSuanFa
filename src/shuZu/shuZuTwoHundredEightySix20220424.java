package shuZu;

import java.util.HashSet;
import java.util.Set;

/**
 *date：2022-04-24
 *
 * message :剑指 Offer 04. 二维数组中的查找
 *
 * work :在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 */
public class shuZuTwoHundredEightySix20220424 {
    public static void main(String[] args){}
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0)
            return false;
        int m = matrix[0].length;
        if(m == 0)
            return false;
        if(target < matrix[0][0] || target > matrix[n - 1][m - 1])
            return false;
        for(int i = 0; i < n;i++){
            int[] ma = matrix[i];
            if(target > ma[m - 1])
                continue;
            if(target < ma[0])
                return false;
            int left = 0,right = m - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(ma[mid] == target)
                    return true;
                else if(ma[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
