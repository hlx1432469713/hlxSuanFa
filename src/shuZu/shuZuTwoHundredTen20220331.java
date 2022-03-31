package shuZu;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-03-31
 *
 * message : 1423. 可获得的最大点数
 *
 * work :几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 *
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 *
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 *
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。

 *
 */
public class shuZuTwoHundredTen20220331 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] cardPoints = new int[n];
            for (int i = 0;i < n;i++)
                cardPoints[i] = scanner.nextInt();
            int k = scanner.nextInt();
            int result = maxScore(cardPoints,k);
        }
    }


    static  public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int max = 0;
        int n = k;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        max = Math.max(sum,max);
        for (int i = cardPoints.length - 1;i >= cardPoints.length - k && n >= 0;i--){
            sum = sum - cardPoints[n - 1] + cardPoints[i];
            max = Math.max(sum,max);
            n--;
        }
        return max;
    }
}
