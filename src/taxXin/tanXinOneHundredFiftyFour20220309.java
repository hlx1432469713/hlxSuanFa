package taxXin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-03-09
 *
 * message ：135. 分发糖果(20:20 - 21:35)
 * work :n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 *
 */
public class tanXinOneHundredFiftyFour20220309 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            int n = scanner.nextInt();
            int[] ratings = new int[n];
            for (int i = 0;i < n;i++)
                ratings[i] = scanner.nextInt();
            int result = candy(ratings);
            System.out.println(result);
        }
    }



    static  public int candy(int[] ratings) {
        if (ratings.length == 1)
            return 1;
       int [] sumList = new int[ratings.length];
       //先满足第一个条件--每个孩子至少分配到 1 个糖果
       for (int i = 0; i < sumList.length;i++)
           sumList[i] = 1;
       //先从左往右遍历 ，只判断 （评分）右边节点 大于左边节点，若是，则将右节点 = 左节点糖果数 + 1；
        //遍历结束，这样评分高的右孩子的糖果数 > 左孩子的糖果数
       for (int i = 0;i < ratings.length - 1;i++){
            if(ratings[i] < ratings[i + 1]) {
                sumList[i + 1] = sumList[i] + 1;
           }
       }
       //从右往左遍历，只判断 （评分）左边节点 大于  右边节点
        for (int i = ratings.length - 1;i >=1;i--){
           if(ratings[i] < ratings[i - 1]) {
                sumList[i - 1] = Math.max(sumList[i - 1],sumList[i] + 1);
            }
        }
       int sum = 0;
        for (int i : sumList) {
            sum += i;
        }
        return sum;

    }
}
