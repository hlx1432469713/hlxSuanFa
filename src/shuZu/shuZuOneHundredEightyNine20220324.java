package shuZu;

import java.util.Scanner;

/**
 *date：2022-03-24
 *
 * message :  661. 图片平滑器
 *
 * work : 图像平滑器 是大小为3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 *
 * 每个单元格的 平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。
 *              （即，需要计算蓝色平滑器中 9 个单元格的平均值）。
 *
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
 *
 *
 */
public class shuZuOneHundredEightyNine20220324 {
    public static void main(String args[]){}

    static int[][] path = {{-1,-1},{-1,0},{-1,1},{0,1},{0,-1},{1,0},{1,1},{1,-1}};
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] list = new int[m][n];
        for(int i = 0;i <m;i++)
            for(int j = 0;j < n;j++){
                list[i][j] = num(i,j,img);
            }
        return list;
    }
    public int num(int x,int y,int[][] img){
        int m = img.length;
        int n = img[0].length;
        int sum = img[x][y];
        int index = 1;
        for(int i = 0;i < path.length;i++){
            int x1 = x + path[i][0];
            int y1 = y + path[i][1];
            if(x1 <0 || y1 <0 || x1 >= m || y1 >= n)
                continue;
            sum += img[x1][y1];
            index++;
        }
        return (int)Math.floor(sum / index);
    }
}
