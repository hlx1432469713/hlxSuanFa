package shuZu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *date：2021-12-02
 *
 * message ：相对名次
 *
 * work:给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 *
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 *
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 *
 *
 */
public class shuZuFiftyOne20211202 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            int[] score = new int[num];
            for(int i = 0;i < num;i++)
                score[i] = scanner.nextInt();
            String[] strings = findRelativeRanks(score);
            for(String s : strings)
                System.out.print(s + "        ");
        }

    }
    static  public String[] findRelativeRanks(int[] score) {
        String[] list = {"Gold Medal","Silver Medal","Bronze Medal"};
        String[] result = new String[score.length];
        Map<Integer,Integer> map = new HashMap<>();
        int[] scoreClone = score.clone();
        Arrays.sort(scoreClone);
        for(int n = scoreClone.length - 1; n >=0;n--)
            map.put(scoreClone[n], score.length - n);
        for(int i = 0;i < score.length;i++){
            int flag = map.get(score[i]);
            if(flag <= 3)
                result[i] = list[flag-1];
            else
                result[i] = String.valueOf(flag);
        }
        return result;

    }

}
