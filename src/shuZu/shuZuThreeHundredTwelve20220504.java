package shuZu;

import java.util.LinkedList;
import java.util.Queue;

/**
 *date：2022-05-04
 *
 * message :1823. 找出游戏的获胜者
 *
 * work :共有 n 名小伙伴一起做游戏。小伙伴们围成一圈，按 顺时针顺序 从 1 到 n 编号。确切地说，
 * 从第 i 名小伙伴顺时针移动一位会到达第 (i+1) 名小伙伴的位置，其中 1 <= i < n ，
 * 从第 n 名小伙伴顺时针移动一位会回到第 1 名小伙伴的位置。
 *
 * 游戏遵循如下规则：
 *
 * 从第 1 名小伙伴所在位置 开始 。
 * 沿着顺时针方向数 k 名小伙伴，计数时需要 包含 起始时的那位小伙伴。逐个绕圈进行计数，一些小伙伴可能会被数过不止一次。
 * 你数到的最后一名小伙伴需要离开圈子，并视作输掉游戏。
 * 如果圈子中仍然有不止一名小伙伴，从刚刚输掉的小伙伴的 顺时针下一位 小伙伴 开始，回到步骤 2 继续执行。
 * 否则，圈子中最后一名小伙伴赢得游戏。
 * 给你参与游戏的小伙伴总数 n ，和一个整数 k ，返回游戏的获胜者。
 */
public class shuZuThreeHundredTwelve20220504 {
    public static void main(String[] args){}
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i <= n ;i++ ){
            queue.add(i);
        }
        while(queue.size() > 1){
            for(int i = 1;i < k;i++){
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }
}
