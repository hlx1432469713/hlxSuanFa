package shuZu;

import TreeNode.TreeNode;

import java.util.*;

/**
 *date：2022-04-18
 *
 * message :386. 字典序排数
 *
 * work :给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 *
 */
public class shuZuTwoHundredFiftySeven20220418 {
    public static void main(String[] args){}
    List<Integer> ans = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i = 1;i <= 9;i++){
            dfs(i,n);
        }
        return ans;
    }
    void dfs(int cur, int limit) {
        if(cur > limit)
            return;
        ans.add(cur);
        for(int i = 0; i<= 9;i++)
            dfs(cur * 10 + i,limit);

    }
}
